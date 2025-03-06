package br.edu.insper.desagil.aps3.unter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CentralTest {
    private Central central;


    @BeforeEach
    void setUp(){
        central = new Central();
    }

    @Test
    void nenhumaAvaliacaoPassageiro(){
        Passageiro passageiro = new Passageiro("10", "Mixao");
        assertEquals(0,central.mediaPassageiro(passageiro.getCpf()));
    }

    @Test
    void nenhumaAvaliacaoMotorista(){
        Motorista motorista = new Motorista("20", "Pixao");
        assertEquals(0,central.mediaMotorista(motorista.getCpf()));
    }

    @Test
    void AvaliacoesPassageiro(){
        Passageiro passageiro1 = new Passageiro("10", "Mixao");


        Corrida corrida1 = new Corrida(passageiro1);
        //Não avalia passageiro, logo a nota desse será 0
        central.adiciona(corrida1);

        Corrida corrida2 = new Corrida(passageiro1);
        corrida2.avaliaPassageiro(4);
        central.adiciona(corrida2);

        Corrida corrida3 = new Corrida(passageiro1);
        corrida3.avaliaPassageiro(5);
        central.adiciona(corrida3);

        Passageiro passageiro2 = new Passageiro("23", "Lebron");

        Corrida corrida4 = new Corrida(passageiro2);
        corrida4.avaliaPassageiro(3);
        central.adiciona(corrida4);

        assertEquals(4.5,central.mediaPassageiro(passageiro1.getCpf()));
    }

    @Test
    void avaliacoesMotorista(){

        Passageiro passageiro = new Passageiro ("23", "Lebron");
        Motorista motorista1 = new Motorista ("6", "James");

        Corrida corrida1 = new Corrida(passageiro);
        corrida1.setMotorista(motorista1);
        //Não avalia motorista, logo a nota desse será 0
        central.adiciona(corrida1);

        Corrida corrida2 = new Corrida(passageiro);
        corrida2.setMotorista(motorista1);
        corrida2.avaliaMotorista(2);
        central.adiciona(corrida2);

        Corrida corrida3 = new Corrida(passageiro);
        corrida3.setMotorista(motorista1);
        corrida3.avaliaMotorista(3);
        central.adiciona(corrida3);

        //Corrida com outro motorista
        Motorista motorista2 = new Motorista ("13","Dame");

        Corrida corrida4 = new Corrida(passageiro);
        corrida4.setMotorista(motorista2);
        corrida4.avaliaMotorista(1);
        central.adiciona(corrida4);

        //Corrida com motorista null
        Corrida corrida5 = new Corrida(passageiro);
        corrida5.avaliaMotorista(1);
        central.adiciona(corrida5);

        //Verificando se a média do 1 motorista é 2.5
        assertEquals(2.5, central.mediaMotorista(motorista1.getCpf()));

    }

}
