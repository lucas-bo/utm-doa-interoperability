package utm.agents.sisantinho.service;

import utm.agents.sisantinho.domain.Operator;
import utm.agents.sisantinho.repository.OperatorRepository;

public class OperatorService {
    public static void save(Operator operator){
        OperatorRepository.save(operator);
    }

    public static void delete(int id){
        OperatorRepository.delete(id);
    }

    public static void update(Operator operator){
        OperatorRepository.update(operator);
    }
}
