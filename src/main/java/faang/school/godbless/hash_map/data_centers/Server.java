package faang.school.godbless.hash_map.data_centers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}
