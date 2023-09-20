package mysql.agents.test;

import mysql.agents.domain.Operator;
import mysql.agents.repository.OperatorRepository;

public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Operator operator = 
            Operator.builder()
                .name("Larissa Bastos Oliveira")
                .cpf(12378878)
                .email("larissa.oliveira@ga.ita.br")
                .build();
        OperatorRepository.save(operator);
    }
}
