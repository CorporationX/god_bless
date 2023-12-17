package faang.school.godbless.OptimizingWorkDataCenter;

import lombok.Data;

@Data
public class DataCenterService implements OptimizationStrategy {
    private final DataCenter dataCenter = new DataCenter();
    public void addServer(Server server) {
        dataCenter.getServerSet().add(server);
    }

    public void deleteServer(Server server) {
        dataCenter.getServerSet().remove(server);

    }

    public double getTotalEnergyConsumption() {        //информация о потреблении электроэнергии всеми серверами
        double allEnergy = 0;
        for (Server server : dataCenter.getServerSet()) {
            allEnergy += server.getEnergyConsumption();
        }
        return allEnergy;
    }

    public void allocateResources(ResourceRequest request) {     //метод для выделения ресурсов
        boolean flag = true;
        for (Server server : dataCenter.getServerSet()) {
            if (server.getMaxLoad() - server.getLoad() > request.getLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                flag = false;
                System.out.println("Ресурсы выделены"); //для удобства проверки
                break;
            }
        }
        if (flag)
            System.out.println("Свободного сервера нет. Ожидайте");
    }

    public void releaseResources(ResourceRequest request) {      //метод для высвобождения ресурсов на запрос
        boolean flag = true;
        for (Server server : dataCenter.getServerSet()) {
            if (server.getLoad() > request.getLoad()) {
                server.setLoad(server.getLoad() - request.getLoad());
                flag = false;
                System.out.println("Ресурсы высвобождены"); //для удобства проверки
                break;
            }
        }
        if (flag)
            System.out.println("Нет ресурсов для высвобождения");
    }


    @Override
    public void optimize(DataCenter dataCenter) {
    try {
        for (Server server1: dataCenter.getServerSet()){
            for(Server server2: dataCenter.getServerSet()){
                if (server1.getLoad() < server2.getMaxLoad()- server2.getLoad()){
                    server2.setLoad(server2.getLoad() + server1.getLoad());
                    server1.setLoad(0);
                }
            }
        }
        Thread.sleep(3*10^7);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    }
}
