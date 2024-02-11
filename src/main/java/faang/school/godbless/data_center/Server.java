package faang.school.godbless.data_center;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

}
