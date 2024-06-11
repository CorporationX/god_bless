package faang.school.godbless.core_split.data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Server {

    private double load;

    private double maxLoad;

    private double energyConsumption;

    public void allocateLoad(double load) {
        this.load += load;
    }

    public void releaseLoad(double load) {
        this.load -= load;
    }
}