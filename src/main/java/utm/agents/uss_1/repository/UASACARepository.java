package utm.agents.uss_1.repository;

import utm.agents.sisantinho.domain.UAS;
import utm.agents.uss_1.conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UASACARepository {
    /* Na realidade esse tipo de função não funcionaria desse jeito.
     * Não seria possível ter acesso direto ao banco de dados da ACA (sisantinho).
     * O melhor que daria para ser feito seria fazer uma solicitação à ACA com algum tipo
     * de identificador do UAS para saber se ele tem registro ou não.
     * 
     * boolean check_if_UAS_is_registered_in_ACA(String serial_number){
     *      send_request_to_ACA(String serial_number);
     * }
     */
    public static List<UAS> findBySerialNumber(String serial_number_part){
        log.info("Finding UAS in sisantinho by serial number: {}", serial_number_part);
        List<UAS> uass_sisantinho = new ArrayList<>();
        String sql = """
                SELECT * FROM sisantinho.UAS WHERE serial_number like '%%%s%%'
                """.formatted(serial_number_part);
        try(
            Connection conn = ConnectionFactory.getACAConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()){
                UAS uas = UAS.builder()
                            .id(rs.getInt("id"))
                            .manufacturer(rs.getString("manufacturer"))
                            .model(rs.getString("model"))
                            .serial_number(rs.getString("serial_number"))
                            .experimental(rs.getBoolean("experimental"))
                            .operator_id(rs.getInt("operator_id"))
                            .maximum_flying_weigh(rs.getDouble("maximum_flying_weigh"))
                            .build();
                uass_sisantinho.add(uas);
            }
        } catch (Exception e) {
            log.error("Error trying to find UAS with serial number: '%s'".formatted(serial_number_part), e);
        }

        return uass_sisantinho;
    }

    public static Integer findHowManyBySerialNumber(String serial_number){        
        return findBySerialNumber(serial_number).size();
    }
}
