package DataCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataCenterService {
    private static DataCenter dataCenter;


    //добавление серверов
    public static void addServers(int numberOfServers){
        //Получим доступ к списку серверов
        List<Server> listOfServers = dataCenter.getListOfServers();

        for (int i = 0; i < numberOfServers; i++) {
        listOfServers.add(new Server(0, 100));
        }

        dataCenter.setListOfServers(listOfServers);
    }

    //удаление серверов
    public static void removeServer(DataCenter dataCenter){
        //Найти свободный сервер/серверы
        //ЕСЛИ нашли - удалить
        if (dataCenter.getLoadServersMap().containsKey(0.0)){
            dataCenter.getLoadServersMap().remove(0.0);
        } else {
            //ИНАЧЕ - освободить самый слабозагруженный
            List<Server> foundServers = new ArrayList<>();
            //Найдем список самых слабозагруженных
            double minLoad = Double.MAX_VALUE;
            for (Map.Entry<Double, List<Server>> entry : dataCenter.getLoadServersMap().entrySet()){
                if (minLoad > entry.getKey()){
                    minLoad = entry.getKey();
                }
            }
            //Удаляем (удалится весь список с текущей нагрузкой)
            dataCenter.getLoadServersMap().remove(minLoad);
        }
    }


    //инфо об энергопотреблении всеми серверами
    public static double getTotalEnergyConsumption(){
        double totalEnergy = 0;

        for (Server server : dataCenter.getListOfServers()){
            totalEnergy += server.getEnergyConsumption();
        }
        return totalEnergy;
    }

    //инфо о свободных ресурсах
    public static double getTotalFreeResources(){
        double freeResources = 0.0;

        for (Server server : dataCenter.getListOfServers()){
            freeResources += server.getMaxLoad() - server.getLoad();
        }
        return freeResources;
    }

    //выделение ресурсов
    //allocateResources(ResourceRequest request)
    public static void allocateResources(ResourceRequest request){
        //Узнаем, возможно ли впринципе выделить столько ресурсов
        //Если не хватает - докупаем сервер
        if (DataCenterService.getTotalFreeResources() < request.getLoad()){
            //Пусть стандартная максимальная нагрузка будет равна 100
            DataCenterService.addServers((int) (request.getLoad()/100 + 1));

        }
        //Иначе - перераспределяем (если нужно) и выделяем
    }

    //высвобождение ресурсов
    //releaseResources(ResourceRequest request)
}
