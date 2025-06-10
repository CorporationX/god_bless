package school.faang.data_center;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Server {
    private final int id;
    private double load;
    private final double maxLoad;
    private double energyConsumption;
}
