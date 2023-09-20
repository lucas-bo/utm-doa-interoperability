package mysql.agents.repository;

import java.sql.Connection;
import java.sql.Statement;

import lombok.extern.log4j.Log4j2;
import mysql.agents.conn.ConnectionFactory;
import mysql.agents.domain.Operator;

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
            e.printStackTrace();
        } 
    }
}
