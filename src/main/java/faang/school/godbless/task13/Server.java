package faang.school.godbless.task13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
    private double load = 0.0d;
    private double maxLoad = 100.0d;
    private double energyConsumption = 10.0d;
}
