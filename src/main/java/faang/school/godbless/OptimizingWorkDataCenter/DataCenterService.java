package faang.school.godbless.OptimizingWorkDataCenter;

public class DataCenterService implements OptimizationStrategy{
    public void addServer(double load, double maxLoad, double energyConsumption){
        DataCenter.getServerSet().add(new Server(load, maxLoad, energyConsumption));
    }

    public void deleteServer(Server server){
        DataCenter.getServerSet().remove(server);

    }

    public double getTotalEnergyConsumption(){        //информация о потреблении электроэнергии всеми серверами
        double allEnergy = 0;
        for(Server server: DataCenter.getServerSet()){
            allEnergy += server.getEnergyConsumption();
        }
        return allEnergy;
    }

    public void allocateResources(ResourceRequest request){     //метод для выделения ресурсов

    }

    public void releaseResources(ResourceRequest request){      //метод для высвобождения ресурсов на запрос

    }


    @Override
    public void optimize(DataCenter dataCenter) {

    }
}
