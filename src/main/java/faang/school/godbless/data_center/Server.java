package faang.school.godbless.data_center;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Server {
    @Setter
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
