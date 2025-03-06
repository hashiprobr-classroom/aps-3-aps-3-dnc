package br.edu.insper.desagil.aps3.unter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoristaTest {
    private Motorista motorista;
    private Corrida corrida;
    private Passageiro passageiro;


    @BeforeEach
    void setUp() {
        motorista = new Motorista("10", "Matheus");
    }

    @Test
    void constroi() {
        assertEquals("10", motorista.getCpf());
        assertEquals("Matheus", motorista.getNome());
    }

    @Test
    void mudaNome() {
        motorista.setNome("Neto");
        assertEquals("Neto", motorista.getNome());
    }

    @Test
    void avalia() {
        passageiro = new Passageiro("50", "Maximus");
        corrida = new Corrida(passageiro);
        motorista.avalia(corrida,3);
        assertEquals(3, corrida.getNotaPassageiro());
    }

    @Test
    void avaliaBaixo() {
        passageiro = new Passageiro("50", "Maximus");
        corrida = new Corrida(passageiro);
        motorista.avalia(corrida,0);
        assertEquals(1, corrida.getNotaPassageiro());
    }
    @Test
    void avaliaAlto() {
        passageiro = new Passageiro("50", "Maximus");
        corrida = new Corrida(passageiro);
        motorista.avalia(corrida, 6);
        assertEquals(5, corrida.getNotaPassageiro());
    }
}
