package school.faang.data_center;

import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

interface OptimizationStrategy {

    default void optimize(DataCenter dataCenter) {
        dataCenter.getServers().sort(Comparator.comparingDouble(Server::getLoad).reversed());
        for (Server observableServer : dataCenter.getServers()) {
            double valueLoad = observableServer.getLoad();
            double maxload = observableServer.getMAX_LOAD();
            if (maxload < valueLoad) {
                observableServer.setLoad(maxload);
                double remainder = valueLoad - maxload;
                for (Server receivingServer : dataCenter.getServers()) {
                    double valueLoadReceivingServer = receivingServer.getLoad();
                    // Проверяем, есть ли свободные ресурсы на сервере
                    if (valueLoadReceivingServer < receivingServer.getMAX_LOAD()) {
                        // Сколько ресурсов сервер может принять
                        double freeResourceLoad = receivingServer.getMAX_LOAD() - valueLoadReceivingServer;
                        if (freeResourceLoad > remainder) {
                            // может принять всю оставшуюся нагрузку
                            receivingServer.setLoad(valueLoadReceivingServer + remainder);
                            remainder = 0;
                            break;  // Завершаем, распределено
                        } else {
                            // Если сервер может принять только часть нагрузки
                            receivingServer.setLoad(valueLoadReceivingServer + freeResourceLoad);
                            remainder = remainder - freeResourceLoad;  // остаток
                        }
                    }
                }
                if (remainder > 0) {
                    System.out.println("Внимание сервер перегружен! нераспределенного ресурса осталось: " + remainder);
                } else {
                    System.out.println("Оптимизация прошла успешно");
                }
            }
        }
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            optimize(dataCenter);
        }, 30, 30, TimeUnit.MINUTES);
    }
}
