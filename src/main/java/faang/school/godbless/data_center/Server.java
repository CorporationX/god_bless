package faang.school.godbless.data_center;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Server {
    private String name;
    private double load;
    private double maxLoad;
    private double energyConsumption;
}