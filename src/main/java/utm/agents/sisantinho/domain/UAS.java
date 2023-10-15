package utm.agents.sisantinho.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UAS {
    private Integer id;
    private String manufacturer;
    private String model;
    private Integer operator_id;
    private double maximum_flying_weigh;
    private String serial_number;
    private boolean experimental;
}
