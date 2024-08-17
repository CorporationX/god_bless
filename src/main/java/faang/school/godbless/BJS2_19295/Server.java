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
        if (this.load + load <= maxLoad) {
            this.load += load;
        } else {
            throw new IllegalArgumentException("The load exceeds the maximum permissible load");
        }
    }
    public void releaseLoad(double load) {
        if (this.load - load >= 0) {
            this.load -= load;;
        } else {
            throw new IllegalArgumentException("The load exceeds the maximum releasable load");
        }
    }
}
