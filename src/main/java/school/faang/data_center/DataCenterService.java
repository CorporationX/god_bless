package school.faang.data_center;

import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class DataCenterService implements OptimizationStrategy {

    protected void addServerToDataCenter(Server server) {
        DataCenter.SERVERS.add(server);
    }

    protected void removeServerFromDataCenter(Server server) {
        DataCenter.SERVERS.remove(server);
    }

    protected double getTotalEnergyConsumption() {
        AtomicReference<Double> totalEnergy = new AtomicReference<>(0.0);
        DataCenter.SERVERS.forEach(server -> {
            totalEnergy.updateAndGet(atom -> (double) (atom + server.getEnergyConsumption()));
        });
        return totalEnergy.get();
    }

    protected void allocateResources(ResourceRequest request) {
        //сортируем чтобы получить сначала менее загруженные
        DataCenter.SERVERS.sort(Comparator.comparingDouble(Server::getLoad));
        double newResourceLoad = request.load();
        for (Server server : DataCenter.SERVERS) {
            double valueLoad = server.getLoad();
            double maxValueLoad = server.getMAX_LOAD();
            double freeResourceOnServer = maxValueLoad - valueLoad;
            if (freeResourceOnServer >= newResourceLoad) {
                server.setLoad(valueLoad + newResourceLoad);
                break;
            } else {
                newResourceLoad = newResourceLoad - freeResourceOnServer;
                server.setLoad(freeResourceOnServer);
            }
        }
    }

    protected void releaseResources(ResourceRequest request) {
        //Сортируем, чтобы сначало освободить самые загруженные серверы
        DataCenter.SERVERS.sort(Comparator.comparingDouble(Server::getLoad).reversed());
        double releaseResource = request.load();
        for (Server server : DataCenter.SERVERS) {
            double valueLoad = server.getLoad();
            if (valueLoad - releaseResource > 0) {
                server.setLoad(valueLoad - releaseResource);
                break;
            } else {
                releaseResource = releaseResource - valueLoad;
                server.setLoad(0);
            }
            if (releaseResource == 0) {
                break;
            }
        }

    }

    @Override
    public void optimize(DataCenter dataCenter) {
        //сортируем, сначало самые загруженные
        dataCenter.SERVERS.sort(Comparator.comparingDouble(Server::getLoad).reversed());
        for (Server observableServer : dataCenter.SERVERS) {
            double valueLoad = observableServer.getLoad();
            double maxload = observableServer.getMAX_LOAD();
            if (maxload < valueLoad) {
                double remainder = valueLoad - maxload;
                for (Server receivingServer : dataCenter.SERVERS) {
                    double valueLoadReceivingServer = receivingServer.getLoad();
                    if (valueLoadReceivingServer > receivingServer.getMAX_LOAD()) {
                        double freeResourceLoad = receivingServer.getMAX_LOAD() - valueLoadReceivingServer;
                        if (freeResourceLoad > remainder) {
                            receivingServer.setLoad(valueLoadReceivingServer + remainder);
                            break;
                        } else {
                            remainder = remainder - freeResourceLoad;
                            receivingServer.setLoad(freeResourceLoad);
                        }
                    }
                }
                if (remainder > 0) {
                    System.out.println("Внимание сервер перегружен!");
                } else {
                    System.out.println("Оптимизация прошла успешно");
                }
            }
        }
        //Запускаем оптимизацию каждые полчаса
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            optimize(dataCenter);
        }, 0, 30, TimeUnit.MINUTES);
    }
}
