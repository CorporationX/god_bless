package DataCenter;

import java.util.List;

public class DataCenterService {
    private DataCenter dataCenter;

    //добавление серверов
    public void addServers(int numberOfServers){
        //Получим доступ к списку серверов
        List<Server> listOfServers = dataCenter.getServerList();

        for (int i = 0; i < numberOfServers; i++) {
        listOfServers.add(new Server(0, 100));
        }

        dataCenter.setServerList(listOfServers);
    }

    //удаление серверов
    public void removeServer(){
        //найти свободный сервер

        //ЕСЛИ нашли - удалить
        //ИНАЧЕ - освободить самый слабозагруженный
        //Удалить

    }


    //инфо об энергопотреблении всеми серверами
    public double getTotalEnergyConsumption(){
        double totalEnergy = 0;

        List<Server> serverList = dataCenter.getServerList();
        for (Server server : serverList){
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    //выделение ресурсов
    //allocateResources(ResourceRequest request)

    //высвобождение ресурсов
    //releaseResources(ResourceRequest request)
}
