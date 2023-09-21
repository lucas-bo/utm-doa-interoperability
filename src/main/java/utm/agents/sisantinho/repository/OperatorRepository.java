package utm.agents.sisantinho.repository;

import java.sql.Connection;
import java.sql.Statement;

import lombok.extern.log4j.Log4j2;
import utm.agents.sisantinho.conn.ConnectionFactory;
import utm.agents.sisantinho.domain.Operator;

@Log4j2
public class OperatorRepository {
    public static void save(Operator operator){
        String sql = """
                    INSERT INTO sisantinho.operator (name, cpf, email) 
                    VALUES ('%s',%d,'%s')"""
                        .formatted(operator.getName(), operator.getCpf(), operator.getEmail());
        try 
        (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()
        ){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected);
        } catch (Exception e) {
            log.error("Error while trying to insert operator '{}'", operator.getName(), e);
        } 
    }

    public static void delete(int id){
        String sql = """
                    DELETE FROM sisantinho.operator 
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
            log.error("Error while trying to insert operator '{}'", id, e);
        } 
    }

    public static void update(Operator operator){
        String sql = """
                    UPDATE sisantinho.operator 
                    SET name = '%s', cpf = '%d', email = '%s' 
                    WHERE (id = '%d')"""
                        .formatted(operator.getName(), operator.getCpf(), operator.getEmail(), operator.getId());
        try 
        (
            Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()
        ){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected {}", rowsAffected);
        } catch (Exception e) {
            log.error("Error while trying to update operator '{}'", operator.getId(), e);
        } 
    }
}
