package faang.school.godbless.OptimizingWorkDataCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Server {
    private double load; //отражает текущцю нагрузку на сервер
    private double maxLoad; //отражает максимальную нагрузку на сервер
    private double energyConsumption; //отражает текущие энергозатраты сервера
}
