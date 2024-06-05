package faang.school.godbless.data_center;

public class DataCenterService {

    public void addServer(DataCenter dataCenter, Server server){
        if(server != null){
            dataCenter.getServerList().add(server);
        }
    }

    public void removeSever(DataCenter dataCenter, Server server){
        if(server != null){
            dataCenter.getServerList().remove(server);
        }
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter){
        double totalEnergyConsumption = 0;
        for(Server server : dataCenter.getServerList()){
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public void allocateResources(DataCenter dataCenter, ResourceRequest request){
        dataCenter.getServerList();
    }
    public void releaseResources(DataCenter dataCenter, ResourceRequest request){

    }

    public void loadBalancingOptimizationStrategy(DataCenter dataCenter){

    }

    public void energyEfficencyOptimizationStrategy(DataCenter dataCenter){

    }

    public void changeOptimizationStrategy(DataCenter dataCenter, OptimizationStrategy optimizationStrategy){
        dataCenter.setOptimizationStrategy(optimizationStrategy);
    }

    public void optimize(DataCenter dataCenter){
        switch (dataCenter.getOptimizationStrategy()){
            case LOAD_BALANCING_OPTIMIZATION_STRATEGY :
                loadBalancingOptimizationStrategy(dataCenter);
                break;
            case ENERGY_EFFICIENCY_OPTIMIZATION_STRATEGY:
                energyEfficencyOptimizationStrategy(dataCenter);
        }
    }
}
