package data.centre;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimpleOptimizationStrategy implements OptimizationStrategy {

    /*
    Останавливает сервера, если они не используются.
    Добавил паузу в 5 секунд для имитации сканирования системы.
     */
    @Override
    public void optimize(DataCenter dataCenter) {
        Set<Integer> deleteServerIdSet = new HashSet<>();

        for (Map.Entry<Integer, Server> entry : dataCenter.getServerIdMap().entrySet()) {
            int serverId = entry.getKey();
            Server server = entry.getValue();
            if (server.getLoad() == 0) {
                deleteServerIdSet.add(serverId);
            }
        }

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
                dataCenter.getServerIdMap().remove(serverId);
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
