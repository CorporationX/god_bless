package faang.school.godbless.optimizing_the_work_of_the_data_center.main;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
