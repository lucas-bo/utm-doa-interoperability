package utm.agents.uss_1.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UAS {
    private Integer id;
    private String serial_number;
    private double latitude;
    private double longitude;
}