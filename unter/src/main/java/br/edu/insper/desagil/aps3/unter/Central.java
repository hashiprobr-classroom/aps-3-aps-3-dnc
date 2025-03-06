package br.edu.insper.desagil.aps3.unter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Central {
    private List<Corrida> corridas;

    public Central(){
        this.corridas = new ArrayList<>();
    }

    public void adiciona (Corrida corrida){
        corridas.add(corrida);
    }

    public double mediaPassageiro (String cpf){
        double soma = 0;
        int i =0;//contador
        if (corridas.isEmpty()){
            return 0;
        }
        for (Corrida corrida : corridas){
            if (Objects.equals(corrida.getPassageiro().getCpf(), cpf)){
                if (corrida.getNotaPassageiro() != 0){
                    soma += corrida.getNotaPassageiro();
                    i+=1;

                }
            }
        }
        return soma/i; //média das notas do passageiro
    }

    public double mediaMotorista (String cpf){
        double soma = 0;
        int i =0; //contador
        if (corridas.isEmpty()){
            return 0;
        }
        for (Corrida corrida : corridas){
            if (corrida.getMotorista()!=null) {
                if (Objects.equals(corrida.getMotorista().getCpf(), cpf)) {
                    if (corrida.getNotaMotorista() != 0) {
                        soma += corrida.getNotaMotorista();
                        i += 1;

                    }
                }
            }
        }
        return soma/i; //média das notas do motorista
    }


}
