package Optimise;

public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public void setOptimizationStrategy(OptimizationStrategy optimizationStrategy) {
        this.optimizationStrategy = optimizationStrategy;
    }

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addService(Server server){
        dataCenter.servers().add(server);
    }
    public void removeService(Server server){
        dataCenter.servers().remove(server);
    }
    public double getTotalEnergyConsumption(){
        double result = 0;
        for(Server server: dataCenter.servers()){
            result += server.energyConsumption();
        }
        return result;
    }
    public void allocateResources(ResourceRequest request){
        System.out.println("Выделился ресурс размером " + request.load());
    }

    public void releaseResources(ResourceRequest request){
        System.out.println("Высвободился ресурс размером " + request.load());
    }

    public void optimiseDataCenter(){
        optimizationStrategy.optimize(dataCenter);
    }

}
