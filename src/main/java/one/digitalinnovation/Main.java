package one.digitalinnovation;

import one.digitalinnovation.dominio.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args){
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Java Básico");;
        cursoJava.setDescricao("Aprenda os conceitos básicos sobre Java.");
        cursoJava.setCargaHoraria(8);

        Curso cursoDotNet = new Curso();
        cursoDotNet.setTitulo("Java .NET");;
        cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre C#.");
        cursoDotNet.setCargaHoraria(8);

        Curso cursoJavaAvancado = new Curso();
        cursoJavaAvancado.setTitulo("Java Avançado");
        cursoJavaAvancado.setDescricao("Aprenda os conceitos avançados sobre Java.");
        cursoJavaAvancado.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aprendendo Orientação e Objetos com Java");
        mentoria.setDescricao("Imersão sobre os pilares da Orientação a Objetos.");
        mentoria.setData(LocalDateTime.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("GFT START #2 Java");
        bootcamp.setInicio(LocalDate.now());
        bootcamp.setFim(bootcamp.getInicio().plusDays(45));
        List<Conteudo> conteudos = Arrays.asList(cursoJava,cursoDotNet,cursoJavaAvancado, mentoria);
        bootcamp.setConteudos(conteudos);

        Dev geovane = new Dev();
        geovane.setNome("Geovane");

        geovane.inscrever(cursoDotNet);
        geovane.inscrever(cursoJavaAvancado);
        geovane.progredir();
        geovane.progredir();


        Dev jonas = new Dev();
        jonas.setNome("Jonas");
        jonas.inscrever(bootcamp);
        jonas.progredir();
        jonas.progredir();

        System.out.println(String.format("XP Geovane: %.2f", geovane.calcularTotalXp()));
        System.out.println(String.format("XP Jonas: %.2f", jonas.calcularTotalXp()));

        List<Dev> ranking = Arrays.asList(geovane, jonas).stream()
                .sorted((dev1, dev2) -> Double.compare(dev1.calcularTotalXp(), dev2.calcularTotalXp()))
                .collect(Collectors.toList());

        for(Dev dev : ranking){
            System.out.println(dev.getNome());
        }
    }


}
