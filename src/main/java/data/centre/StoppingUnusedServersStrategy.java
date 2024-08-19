package data.centre;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StoppingUnusedServersStrategy implements OptimizationStrategy {

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
            Integer[] serverId = deleteServerIdSet.toArray(new Integer[0]);
            int size = serverId.length;
            for (int i = 0; i < size; i++) {
                dataCenter.getServerIdMap().remove(serverId[i]);
                result.append(serverId[i]);
                if (i < size - 1) {
                    result.append(", ");
                }
            }
            result.append(" был(и) остановлен(ы).");
            System.out.println("Оптимизация завершена. " + result);
            deleteServerIdSet.clear();
        } else {
            System.out.println("Оптимизация завершена. Серверов для отключения нет.");
        }
    }
}
