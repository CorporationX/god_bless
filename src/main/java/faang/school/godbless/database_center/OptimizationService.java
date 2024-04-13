package faang.school.godbless.database_center;

public class OptimizationService implements  OptimizationStrategy{

    @Override
    public  void optimize(DataCenter dataCenter) {
        double efficiency = findEfficiency(dataCenter);

        for (Server server : dataCenter.getListOfServers()){
            server.setLoad(efficiency * server.getMaxLoad());
        }
        System.out.println("The DataCenter has been optimized.");
    }

    private Double findEfficiency(DataCenter dataCenter){

        double totalLoad = 0;
        double maxTotalLoad = 0;
        for (Server server : dataCenter.getListOfServers()) {
            totalLoad += server.getLoad();
            maxTotalLoad += server.getMaxLoad();
        }
        return totalLoad / maxTotalLoad;
    }
}
