package school.faang.data_center;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode(exclude = {"load", "energyConsumption"})
@AllArgsConstructor
public class Server {
    private final int id;
    private double load;
    private final double maxLoad;
    private double energyConsumption;
}
