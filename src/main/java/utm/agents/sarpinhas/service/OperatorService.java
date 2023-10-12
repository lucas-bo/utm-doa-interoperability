package utm.agents.sarpinhas.service;

import utm.agents.sarpinhas.domain.Operator;
import utm.agents.sarpinhas.repository.OperatorRepository;

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
