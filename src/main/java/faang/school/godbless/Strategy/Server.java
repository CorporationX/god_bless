package faang.school.godbless.Strategy;

import faang.school.godbless.loadExceptions.ExcessLoadException;
import faang.school.godbless.loadExceptions.NegativeLoadException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.load = 0;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public void allocateLoad(double load) throws ExcessLoadException {
        if (this.load + load <= maxLoad) {
            this.load += load;
            System.out.println(this + " allocate " + load);
        } else {
            throw new ExcessLoadException("Load = " + this.load + load + "maxLoad = " + maxLoad);
        }
    }

    public void releaseLoad(double load) throws NegativeLoadException, ExcessLoadException {
        if (load < 0) {
            throw new NegativeLoadException("load = " + load);
        }
        if (this.load < load) {
            throw new ExcessLoadException("Cannot release load: not enough load allocated.");
        }
        this.load -= load;
        System.out.println(this + " release " + load);
    }

}
