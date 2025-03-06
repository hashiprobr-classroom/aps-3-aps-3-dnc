package br.edu.insper.desagil.aps3.unter;

public class Corrida {
    private Passageiro passageiro;
    private Motorista motorista;
    private int notaPassageiro; //nota recebida pelo passageiro, dada pelo motorista
    private int notaMotorista;

    public Corrida(Passageiro passageiro) {
        this.passageiro = passageiro;
        this.motorista = null;
        this.notaPassageiro = 0;
        this.notaMotorista = 0;

    }

    public void avaliaPassageiro (int nota){
        notaPassageiro = arredonda (nota);
    }

    public void avaliaMotorista (int nota){
        notaMotorista = arredonda (nota);
    }



    private int arredonda (int nota) {
        if (nota < 1) {
            return 1;
        }
        else if (nota > 5) {
            return 5;
        }
        return nota;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public int getNotaPassageiro() {
        return notaPassageiro;
    }

    public int getNotaMotorista() {
        return notaMotorista;
    }
}
