package utm.agents.uss_1.test;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import utm.agents.uss_1.domain.UAS;
import utm.agents.uss_1.service.UASService;

@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) {
        UAS uas_registered = 
            UAS.builder().
                serial_number("AJDJ38893").
                latitude(0d).
                longitude(0d).
                build();
    
        UAS uas_unregistered = 
            UAS.builder().
                serial_number("SDJ-334-344LL").
                latitude(0d).
                longitude(0d).
                build();

        //UASService.save(uas_registered);
        //UASService.save(uas_unregistered);
        List<UAS> uass = UASService.findAll();
        List<UAS> uass_by_sn = UASService.findBySerialNumber("AJDJ");
        log.info("UASs found: '{}'", uass_by_sn);

        for (UAS uas : uass) {
            if(UASService.checkIfRegisteredBySerialNumber(uas.getSerial_number())){
                log.info("UAS with serial number '{}' is registered", uas.getSerial_number());
            }
            else{
                log.info("UAS with serial number '{}' is not registered", uas.getSerial_number());
            }
        }
    }
}
