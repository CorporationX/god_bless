package faang.school.godbless;

public class LoadOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = calculateTotalLoad(dataCenter);

        for (Server server : dataCenter.serverList) {
            double load = server.getLoad();
            double maxLoad = server.getMaxLoad();

            double newLoad = totalLoad / dataCenter.serverList.size();

            newLoad = Math.min(newLoad, maxLoad);

            server.setLoad(newLoad);
        }
        System.out.println("Load optimization completed.");
    }

    private double calculateTotalLoad(DataCenter dataCenter) {
        double totalLoad = 0;
        for (Server server : dataCenter.serverList) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }
}
