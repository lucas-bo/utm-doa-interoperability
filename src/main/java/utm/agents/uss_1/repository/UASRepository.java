package utm.agents.uss_1.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import utm.agents.uss_1.conn.ConnectionFactory;
import utm.agents.uss_1.domain.UAS;

@Log4j2
public class UASRepository {
    public static void save(UAS uas){
        String sql = """
                    INSERT INTO uss_1.UAS (serial_number, latitude, longitude) 
                    VALUES ('%s',%f, %f)"""
                        .formatted(uas.getSerial_number(), uas.getLatitude(), uas.getLongitude());
        try 
        (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()
        ){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected);
        } catch (Exception e) {
            log.error("Error while trying to insert uas '{}'", uas.getSerial_number(), e);
        } 
    }

    public static void delete(int id){
        String sql = """
                    DELETE FROM uss_1.UAS
                    WHERE (id = '%d')"""
                        .formatted(id);
        try 
        (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()
        ){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected);
        } catch (Exception e) {
            log.error("Error while trying to insert uas '{}'", id, e);
        } 
    }

    public static List<UAS> findAll(){
        log.info("Finding all UASs");
        String sql = """
                    SELECT * FROM uss_1.UAS""";
        List<UAS> uass = new ArrayList<>();
        try 
        (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                int id = rs.getInt("id");
                String serial_number = rs.getString("serial_number");
                double latitude = rs.getFloat("latitude");
                double longitude = rs.getFloat("longitude");

                UAS uas = UAS.builder().
                              id(id).
                              serial_number(serial_number).
                              latitude(latitude).
                              longitude(longitude).
                              build();
                uass.add(uas);
            }
        } catch (Exception e) {
            log.error("Error while trying to update uas ", e);
        }
        return uass;
    }

    public static List<UAS> findBySerialNumber(String serial_number_part){
        log.info("Finding UAS with serial number part: '{}'.", serial_number_part);
        String sql = """
                    SELECT * FROM uss_1.UAS
                    WHERE serial_number LIKE '%%%s%%'"""
                        .formatted(serial_number_part);
        List<UAS> uass = new ArrayList<>();
        try 
        (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ){
            while(rs.next()){
                int id = rs.getInt("id");
                String serial_number = rs.getString("serial_number");
                double latitude = rs.getFloat("latitude");
                double longitude = rs.getFloat("longitude");

                UAS uas = UAS.builder().
                              id(id).
                              serial_number(serial_number).
                              latitude(latitude).
                              longitude(longitude).
                              build();
                uass.add(uas);
            }
        } catch (Exception e) {
            log.error("Error while trying to update uas ", e);
        }
        return uass;
    }

    public static void update(UAS uas){
        String sql = """
                    UPDATE uss_1.UAS
                    SET serial_number = '%s', latitude = '%f', longitude = '%f' 
                    WHERE (id = '%d')"""
                        .formatted(uas.getSerial_number(), uas.getLatitude(), uas.getLongitude(), uas.getId());
        try 
        (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()
        ){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected);
        } catch (Exception e) {
            log.error("Error while trying to update uas '{}'", uas.getId(), e);
        } 
    }
}
