package data.centre;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class DataCenterService {

    private OptimizationStrategy optimizationStrategy;
    private static int ID = 1;

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.addServer(ID, server);
        System.out.println("Новый сервер с ID [" + ID++ + "] запущен: " + server);
    }

    /*
    Останавливает сервер, если он не под нагрузкой.
     */
    public void deleteServer(DataCenter dataCenter, int id) {
        dataCenter.deleteServer(id);
    }

    /*
    Останавливает сервер, даже если он под нагрузкой,
    при условии, что его нагрузку можно распределить
    по другим серверам.
     */
    public void hardDeleteServer(DataCenter dataCenter, int id) {

        if (!dataCenter.getServerIdMap().containsKey(id)) {
            System.out.println("Сервера с ID [" + id + "] нет.");
            return;
        }

        double loadServerToDelete = dataCenter.getServerIdMap().get(id).getLoad();
        double remainingFreeLoadServer = getTotalServerMaxLoad(dataCenter) - getTotalServerLoad(dataCenter);

        if (remainingFreeLoadServer >= loadServerToDelete) {

            if (dataCenter.getServerIdMap().containsKey(id)) {
                methodForReloadingServers(loadServerToDelete, dataCenter.getServerIdMap());
                dataCenter.getServerIdMap().get(id).setLoad(0);
                dataCenter.deleteServer(id);
            }
        } else {
            System.out.println("Этот сервер важен, сейчас отключить его невозможно.");
        }
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
        return dataCenter.getTotalEnergyConsumption();
    }

    public double getTotalServerLoad(DataCenter dataCenter) {
        return dataCenter.getTotalServerLoad();
    }

    public double getTotalServerMaxLoad(DataCenter dataCenter) {
        return dataCenter.getTotalServerMaxLoad();
    }

    /*
    Выделяет ресурсы под запрос. Если есть мощности, распределяет
    новую нагрузку по существующим серверам. Если мощностей не хватает
    запускает новый сервер.
     */
    public void allocateResources(DataCenter dataCenter, ResourceRequest request) {
        double loadRequest = request.getLoad();
        double freeServerCapacity = dataCenter.getTotalServerMaxLoad() - dataCenter.getTotalServerLoad();
        if (loadRequest > freeServerCapacity) {
            Server newServer = new Server(loadRequest, loadRequest + loadRequest / 2, reloadServerEnergyConsumption(loadRequest));
            addServer(dataCenter, newServer);
        } else {
            methodForReloadingServers(loadRequest, dataCenter.getServerIdMap());
        }
    }

    /*
    Освобождает ресурсы. Если после этого сервера не используются,
    добавляет их в список на отключение.
     */
    public void releaseResources(DataCenter dataCenter, ResourceRequest request) {
        double loadRequest = request.getLoad();
        double totalLoad = dataCenter.getTotalServerLoad();
        if (totalLoad >= loadRequest && loadRequest > 0) {
            double remainingLoadToRelease = loadRequest;

            for (Map.Entry<Integer, Server> entry : dataCenter.getServerIdMap().entrySet()) {

                int serverId = entry.getKey();
                Server server = entry.getValue();
                double loadToReleaseFromServer = Math.min(server.getLoad(), remainingLoadToRelease);
                double newServerLoad = server.getLoad() - loadToReleaseFromServer;
                server.setLoad(newServerLoad);
                server.setEnergyConsumption(reloadServerEnergyConsumption(server.getLoad()));
                remainingLoadToRelease -= loadToReleaseFromServer;

                if (server.getLoad() == 0) {
                    System.out.println("Сервер [" + serverId + "] больше не используется.");
                } else {
                    System.out.println("Сервер [" + serverId + "] теперь нагружен на " +
                            server.getLoad() + " из " + server.getMaxLoad() + ".");
                }
            }
        } else {
            System.out.println("Недостаточно общей нагрукзи на сервера, " +
                    "чтобы освободить запрошенное количество.");
        }
    }

    public void printServers(DataCenter dataCenter) {
        dataCenter.printServers();
    }

    /*
    Метод перераспределения нагрузки по серверам.
     */
    public void methodForReloadingServers(double loadToReloading, Map<Integer, Server> map) {

        for (Map.Entry<Integer, Server> entry : map.entrySet()) {
            int serverId = entry.getKey();
            Server server = entry.getValue();
            double availableCapacity = server.getMaxLoad() - server.getLoad();

            if (availableCapacity > 0) {

                double allocatedCapacity = Math.min(loadToReloading, availableCapacity);
                double newLoadServer = server.getLoad() + allocatedCapacity;

                server.setLoad(newLoadServer);
                server.setEnergyConsumption(reloadServerEnergyConsumption(newLoadServer));
                loadToReloading -= allocatedCapacity;

                if (server.getLoad() == server.getMaxLoad()) {
                    System.out.println("Сервер с ID [" + serverId + "] теперь нагружен на максимум.");
                } else {
                    System.out.println("Сервер с ID [" + serverId + "] теперь нагружен на " +
                            server.getLoad() + " из " + server.getMaxLoad() + ".");
                }

                if (loadToReloading == 0) {
                    break;
                }
            }
        }
    }

    /*
    Метод рассчета потребления энергии у сервера,
    в зависимости от его нагрузки.
     */
    public double reloadServerEnergyConsumption(double load) {
        return load * 0.01;
    }

    public void optimize(DataCenter dataCenter) {
        if (optimizationStrategy != null) {
            optimizationStrategy.optimize(dataCenter);
        } else {
            throw new NullPointerException("Стратегии оптимизации не выбрана");
        }
    }

}
