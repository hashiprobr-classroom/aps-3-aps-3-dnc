package br.edu.insper.desagil.aps3.unter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassageiroTest {
    private Passageiro passageiro;
    private Corrida corrida;


    @BeforeEach
    void setUp() {
        passageiro = new Passageiro("10", "Matheus");
    }

    @Test
    void constroi() {
        assertEquals("10", passageiro.getCpf());
        assertEquals("Matheus", passageiro.getNome());
    }

    @Test
    void mudaNome() {
        passageiro.setNome("Neto");
        assertEquals("Neto", passageiro.getNome());
    }

    @Test
    void avalia() {
        corrida = new Corrida(passageiro);
        passageiro.avalia(corrida,3);
        assertEquals(3, corrida.getNotaMotorista());
    }

    @Test
    void avaliaBaixo() {
        corrida = new Corrida(passageiro);
        passageiro.avalia(corrida,0);
        assertEquals(1, corrida.getNotaMotorista());
    }
    @Test
    void avaliaAlto() {
        corrida = new Corrida(passageiro);
        passageiro.avalia(corrida, 6);
        assertEquals(5, corrida.getNotaMotorista());
    }
}



