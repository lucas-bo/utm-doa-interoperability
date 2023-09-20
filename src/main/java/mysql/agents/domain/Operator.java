package mysql.agents.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Operator {
    private Integer id;
    private String name;
    private Integer cpf;
    private String email;    
}
