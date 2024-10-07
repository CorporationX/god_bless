package school.faang.bjs2_33282_dataCenter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResourceRequest {
    private double load;
    private boolean toAdd;
}
