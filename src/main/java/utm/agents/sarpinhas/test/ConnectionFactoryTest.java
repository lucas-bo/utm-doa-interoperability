package utm.agents.sarpinhas.test;

import utm.agents.sarpinhas.domain.Operator;
import utm.agents.sarpinhas.service.OperatorService;

public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Operator operator = 
            Operator.builder()
                .id(2)
                .name("Larissa Bastos Oliveira")
                .cpf(12378)
                .email("larissa.oliveira@ga.ita.br")
                .build();
        OperatorService.update(operator);
    }
}
