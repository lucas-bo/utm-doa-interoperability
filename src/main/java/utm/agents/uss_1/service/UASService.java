package utm.agents.uss_1.service;

import java.util.List;

import utm.agents.uss_1.domain.UAS;
import utm.agents.uss_1.repository.UASACARepository;
import utm.agents.uss_1.repository.UASRepository;

public class UASService {
    public static void save(UAS uas){
        UASRepository.save(uas);
    }
    public static void delete(Integer id){
        UASRepository.delete(id);
    }
    public static List<UAS> findAll(){
        return UASRepository.findAll();
    }
    public static List<UAS> findBySerialNumber(String serial_number_part){
        return UASRepository.findBySerialNumber(serial_number_part);
    }
    public static boolean checkIfRegisteredBySerialNumber(String serial_number){
        if(UASACARepository.findHowManyBySerialNumber(serial_number) > 0){
            return true;
        }

        return false;
    }
    public static void update(UAS uas){
        UASRepository.update(uas);
    }
}
