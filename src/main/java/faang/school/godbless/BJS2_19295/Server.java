package faang.school.godbless.BJS2_19295;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public void addLoad(double load) {
        this.load += load;
    }
    public void releaseLoad(double load) {
        this.load -= load;
    }
    public void deleteLoad() {
        this.load = 0;
    }
}
