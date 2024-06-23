package faang.school.godbless.sprint_1.hashMap.task_13_dataCenter;

public class DataCenterService implements OptimizationStrategy {
    private final DataCenter dataCenter = new DataCenter();

    public void addServer(Server server) {
        dataCenter.servers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.servers().remove(server);
    }

    public DataCenter dataCenter() {
        return dataCenter;
    }

    /**
     * Вычисляет энергетические затраты ДатаЦентра
     *
     * @return
     */
    public double getTotalEnergyConsumption() {
        double total = 0;

        for (Server server : dataCenter.servers()) {
            total += server.energyConsumption();
        }

        return total;
    }

    /**
     * Выделяет ресурсы первый сервер у которого есть свободные мощности
     *
     * @param request
     */
    public void allocateResources(ResourceRequest request) {
        for (Server server : dataCenter.servers()) {
            if (server.getFreeLoad() > request.load()) {
                server.addLoad(request.load());
                // Энерго потребление тоже увеличивается,
                // но я не фантазировать и не усложнять себе жизнь
            }
        }
    }

    /**
     * Высвобождает ресурсы первый сервер с нагрузкой больше чем в запросе.
     *
     * @param request
     */
    public void releaseResources(ResourceRequest request) {
        for (Server server : dataCenter.servers()) {
            if (server.load() > request.load()) {
                server.freeUpResources(request.load());
                // Энерго потребление...
            }
        }
    }

    /**
     * Оптимизировать загруженность серверов
     *
     * @param dataCenter
     */
    @Override
    public void optimize(DataCenter dataCenter) {
        // Средняя загруженность серверов
        double averageLoad = getAverageLoad(dataCenter);
        // Нагрузка для распределения
        double loadRedistribute = 0;

        // Снимаю лишнюю нагрузку
        for (Server s : dataCenter.servers()) {
            double loadInPercent = s.getServerLoadInPercent();
            if (loadInPercent > averageLoad) {
                double loadToFree = (s.load() - s.maxLoad() * (averageLoad / 100));
                s.freeUpResources(loadToFree);
                loadRedistribute += loadToFree;
            }
        }

        // Нагружаю слабонагруженные сервера
        for (Server s : dataCenter.servers()) {
            double loadInPercent = s.getServerLoadInPercent();
            if (loadInPercent < averageLoad) {
                double loadToAdd = s.maxLoad() * (averageLoad / 100) - s.load();
                // Если распределяемая нагрузка меньше, чем та,
                // которая необходима (из-за небольшого увеличения, чтобы не оставалось остатков),
                // то добавляем всю нагрузку.
                if (loadRedistribute <= loadToAdd * 1.05) {
                    s.addLoad(loadRedistribute);
                    break;
                }
                s.addLoad(loadToAdd);
                loadRedistribute -= loadToAdd;
            }
        }
    }

    /**
     * Вычесление средней загруженности серверов
     *
     * @param dataCenter
     * @return
     */
    private double getAverageLoad(DataCenter dataCenter) {
        double totalLoadInPercent = 0;
        for (Server server : dataCenter.servers()) {
            totalLoadInPercent += server.getServerLoadInPercent();
        }
        return totalLoadInPercent / dataCenter.servers().size();
    }

}





