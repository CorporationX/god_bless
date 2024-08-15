package faang.school.godbless.datacenter.entities;

import faang.school.godbless.datacenter.exceptions.ResourceAllocateException;
import faang.school.godbless.datacenter.exceptions.ResourceReleaseExceptions;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public void allocateLoad(double load) throws ResourceAllocateException {
        if (this.load + load <= maxLoad) {
            this.load += load;
            System.out.println(this + " allocate " + load);
        } else {
            throw new ResourceAllocateException("Load = " + this.load + load + "maxLoad = " + maxLoad);
        }
    }

    public void releaseLoad(double load) throws ResourceReleaseExceptions, ResourceAllocateException {
        if (load < 0) {
            throw new ResourceReleaseExceptions("load = " + load);
        }
        if (this.load < load) {
            throw new ResourceAllocateException("Cannot release load: not enough load allocated.");
        }
        this.load -= load;
        System.out.println(this + " release " + load);
    }
}
