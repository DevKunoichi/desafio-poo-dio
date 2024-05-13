package br.com.dio.desafio.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class MainTest {

    @Test
    void testarInscricaoBootcamp() {
        // Criando cursos, mentoria e bootcamp
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Criando Devs
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");

        // Inscrevendo a Dev Camila no bootcamp
        devCamila.inscreverBootcamp(bootcamp);

        // Assertions para verificar a inscrição
        assertTrue(devCamila.getConteudosInscritos().containsAll(bootcamp.getConteudos()));
        assertEquals(bootcamp.getConteudos().size(), devCamila.getConteudosInscritos().size());
    }

    @Test
    void testarProgressaoBootcamp() {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Criando Devs
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");

        Dev devJoao = new Dev();
        devJoao.setNome("João");

        // Inscrevendo Devs no bootcamp
        devCamila.inscreverBootcamp(bootcamp);
        devJoao.inscreverBootcamp(bootcamp);

        // Progredindo nos conteúdos
        devCamila.progredir();
        devCamila.progredir();

        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        // Assertions para verificar o progresso
        assertEquals(2, devCamila.getConteudosConcluidos().size());
        assertEquals(1, devCamila.getConteudosInscritos().size());
        assertEquals(12, devCamila.calcularTotalXp());

        assertEquals(3, devJoao.getConteudosConcluidos().size());
        assertEquals(0, devJoao.getConteudosInscritos().size());
        assertEquals(20, devJoao.calcularTotalXp());
    }

    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Criando Devs
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");

        Dev devJoao = new Dev();
        devJoao.setNome("João");

        // Inscrevendo Devs no bootcamp
        devCamila.inscreverBootcamp(bootcamp);
        devJoao.inscreverBootcamp(bootcamp);

        // Imprimindo informações iniciais dos Devs
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());

        // Progredindo nos conteúdos
        devCamila.progredir();
        devCamila.progredir();

        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        // Imprimindo informações após o progresso dos Devs
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());
        System.out.println("-------");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());
    }
}