package data.centre;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Getter
@Setter
public class DataCenterService implements OptimizationStrategy {

    protected final static Random RANDOM = new Random();
    private final static int MAX_SERVER_COUNT = 50;
    private Set<Integer> deleteServerIdSet = new HashSet<>();
    protected DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addService(Server server) {
        int finalId = RANDOM.nextInt(MAX_SERVER_COUNT) + 1;
        while (dataCenter.serverIdMap.containsKey(finalId)) {
            finalId++;
        }
        dataCenter.serverIdMap.put(finalId, server);
        System.out.println("Новый сервер с ID [" + finalId + "] запущен: " + server);
    }

    /*
    Останавливает сервер, если он не под нагрузкой.
     */
    public void deleteServer(int id) {

        if (dataCenter.serverIdMap.containsKey(id)) {

            if (dataCenter.serverIdMap.get(id).getLoad() > 0) {
                System.out.println("Нельзя отключить сервер под нагрузкой.");
            } else {
                dataCenter.serverIdMap.remove(id);
                deleteServerIdSet.remove(id);

                System.out.println("Сервер с ID [" + id + "] отключен.");
            }
        } else {
            System.out.println("Сервера с ID [" + id + "] нет.");
        }
    }

    /*
    Останавливает сервер, даже если он под нагрузкой,
    при условии, что его нагрузку можно распределить
    по другим серверам.
     */
    public void hardDeleteServer(int id) {

        if (!dataCenter.serverIdMap.containsKey(id)) {
            System.out.println("Сервера с ID [" + id + "] нет.");
            return;
        }

        double loadServerToDelete = dataCenter.serverIdMap.get(id).getLoad();
        double remainingFreeLoadServer = dataCenter.getTotalServerMaxLoad() - dataCenter.getTotalServerLoad();

        if (remainingFreeLoadServer >= loadServerToDelete) {

            if (dataCenter.serverIdMap.containsKey(id)) {
                double remainingLoadToDistribute = loadServerToDelete;
                methodForReloadingServers(remainingLoadToDistribute, dataCenter.serverIdMap);
                dataCenter.serverIdMap.remove(id);
                deleteServerIdSet.remove(id);
                System.out.println("Сервер с ID [" + id + "] отключен.");
            }
        } else {
            System.out.println("Этот сервер важен, сейчас отключить его невозможно.");
        }
    }

    public double getTotalEnergyConsumption() {
        double result = 0;
        for (Server server : dataCenter.serverIdMap.values()) {
            result += server.getEnergyConsumption();
        }
        return result;
    }

    public double getTotalServerLoad() {
        double totalLoad = 0;
        for (Server server : dataCenter.serverIdMap.values()) {
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public double getTotalServerMaxLoad() {
        double totalMaxLoad = 0;
        for (Server server : dataCenter.serverIdMap.values()) {
            totalMaxLoad += server.getMaxLoad();
        }
        return totalMaxLoad;
    }

    /*
    Выделяет ресурсы под запрос. Если есть мощности, распределяет
    новую нагрузку по существующим серверам. Если мощностей не хватает
    запускает новый сервер.
     */
    public void allocateResources(ResourceRequest request) {
        double loadRequest = request.getLoad();
        double freeServerCapacity = dataCenter.getTotalServerMaxLoad() - dataCenter.getTotalServerLoad();
        if (loadRequest > freeServerCapacity) {
            Server newServer = new Server(loadRequest, reloadServerEnergyConsumption(loadRequest), loadRequest + loadRequest / 2);
            addService(newServer);
        } else {
            methodForReloadingServers(loadRequest, dataCenter.serverIdMap);
//            for (Map.Entry<Integer, Server> entry : dataCenter.serverIdMap.entrySet()) {
//                int serverId = entry.getKey();
//                Server server = entry.getValue();
//                double availableCapacity = server.getMaxLoad() - server.getLoad();
//                if (availableCapacity > 0) {
//                    if (deleteServerIdSet.contains(serverId)) {
//                        deleteServerIdSet.remove(serverId);
//                    }
//                    double allocatedCapacity = Math.min(loadRequest, availableCapacity);
//                    server.setLoad(server.getLoad() + allocatedCapacity);
//                    loadRequest -= allocatedCapacity;
//                    if (server.getLoad() == server.getMaxLoad()) {
//                        System.out.println("Сервер [" + serverId + "] теперь нагружен на максимум.");
//                    } else {
//                        System.out.println("Сервер [" + serverId + "] теперь нагружен на " +
//                                server.getLoad() + " из " + server.getMaxLoad() + ".");
//                    }
//                    if (loadRequest == 0) {
//                        break;
//                    }
//                }
//            }
        }
    }

    /*
    Освобождает ресурсы. Если после этого сервера не используются,
    добавляет их в список на отключение.
     */
    public void releaseResources(ResourceRequest request) {
        double loadRequest = request.getLoad();
        double totalLoad = dataCenter.getTotalServerLoad();
        if (totalLoad >= loadRequest && loadRequest > 0) {
            double remainingLoadToRelease = loadRequest;

            for (Map.Entry<Integer, Server> entry : dataCenter.serverIdMap.entrySet()) {

                int serverId = entry.getKey();
                Server server = entry.getValue();
                double loadToReleaseFromServer = Math.min(server.getLoad(), remainingLoadToRelease);
                double newServerLoad = server.getLoad() - loadToReleaseFromServer;
                server.setLoad(newServerLoad);
                server.setEnergyConsumption(reloadServerEnergyConsumption(server.getLoad()));
                remainingLoadToRelease -= loadToReleaseFromServer;

                if (server.getLoad() == 0) {
                    System.out.println("Сервер [" + serverId + "] больше не используется.");
                    deleteServerIdSet.add(serverId);
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

    public void printServers() {
        for (Map.Entry<Integer, Server> entry : dataCenter.serverIdMap.entrySet()) {
            Server server = entry.getValue();
            System.out.println("Сервер ID: " + entry.getKey() + " и данные: " + server);
        }
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


                if (deleteServerIdSet.contains(serverId)) {
                    deleteServerIdSet.remove(serverId);
                }

                double allocatedCapacity = Math.min(loadToReloading, availableCapacity);
                double newLoadServer = server.getLoad() + allocatedCapacity;

                if (newLoadServer != server.getLoad()) {

                    server.setLoad(newLoadServer);
                    server.setEnergyConsumption(reloadServerEnergyConsumption(newLoadServer));
                    loadToReloading -= allocatedCapacity;

                    if (server.getLoad() == server.getMaxLoad()) {
                        System.out.println("Сервер [" + serverId + "] теперь нагружен на максимум.");
                    } else {
                        System.out.println("Сервер [" + serverId + "] теперь нагружен на " +
                                server.getLoad() + " из " + server.getMaxLoad() + ".");
                    }
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
        double result = load * 0.01;
        return result;
    }

    /*
    Останавливает сервера, если они не используются.
    Добавил паузу в 5 секунд для имитации сканирования системы.
     */
    @Override
    public void optimize(DataCenter dataCenter) {
        StringBuilder result = new StringBuilder();
        System.out.println("Началась оптимизация серверного центра...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!deleteServerIdSet.isEmpty()) {

            result.append("Сервер(а) с ID: ");
            int size = deleteServerIdSet.size();
            int index = 0;
            for (Integer serverId : deleteServerIdSet) {
                dataCenter.serverIdMap.remove(serverId);
                result.append(serverId);
                if (index < size - 1) {
                    result.append(", ");
                }
                index++;
            }
            result.append(" был(и) остановлен(ы).");
            System.out.println("Оптимизация завершена. " + result);
            deleteServerIdSet.clear();
        } else {
            System.out.println("Оптимизация завершена. Серверов для отключения нет.");
        }
    }
}
