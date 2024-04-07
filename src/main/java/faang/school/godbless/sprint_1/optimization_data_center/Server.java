package faang.school.godbless.sprint_1.optimization_data_center;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    // Буду считать что за каждую единицу нагрузки тратится 2 единицы электроэнергии
    public void setLoad(double load) {
        this.load = load;
        this.energyConsumption = load * 2;
    }

    private void allocateResources(double allocateLoad) {
        load += allocateLoad;
        energyConsumption += allocateLoad * 2;
    }

    public double availableResourcesForAllocate(double allocateLoad) {
        double availableResourcesForAllocate = Math.min(getAvailableLoad(), allocateLoad);
        allocateResources(availableResourcesForAllocate);
        return availableResourcesForAllocate;
    }

    public void releaseResources(double releaseLoad) {
        load -= releaseLoad;
        energyConsumption -= releaseLoad * 2;
    }

    public double availableResourcesForRelease(double releaseLoad) {
        double availableResourcesForRelease = Math.min(load, releaseLoad);
        releaseResources(availableResourcesForRelease);
        return availableResourcesForRelease;
    }

    public double getAvailableLoad() {
        return maxLoad - load;
    }

}
