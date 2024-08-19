package faang.school.godbless.LRUCache;
import lombok.NonNull;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    Map<Integer, Data> dataBase = new HashMap<>();
    Map<Integer, Data> dataCache = new LinkedHashMap<>();
    private static final int CACHE_SIZE = 3;

    public static void main(String[] args) {
        Main main = new Main();
        main.clientRequestPOST(new Data(1, 100));
        main.clientRequestPOST(new Data(2, 200));
        main.clientRequestPOST(new Data(3, 300));
        main.clientRequestPOST(new Data(4, 400));
        main.clientRequestPOST(new Data(5, 500));

        try {
            Data data1 = main.clientRequestGET(1);
            System.out.println("Data from GET request: ID = " + data1.getId() + ", Value = " + data1.getValue());
            Data data2 = main.clientRequestGET(2);
            System.out.println("Data from GET request: ID = " + data2.getId() + ", Value = " + data2.getValue());
            Data data3 = main.clientRequestGET(3);
            System.out.println("Data from GET request: ID = " + data3.getId() + ", Value = " + data3.getValue());
            main.printCacheState();
            Data data_3 = main.clientRequestGET(3);
            System.out.println("Data from GET request: ID = " + data_3.getId() + ", Value = " + data_3.getValue());
            Data data4 = main.clientRequestGET(4);
            System.out.println("Data from GET request: ID = " + data4.getId() + ", Value = " + data4.getValue());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        main.printCacheState();
    }

    public void addDataToDBase(@NonNull Data data) {
        data.updateTimestamp();
        dataBase.computeIfAbsent(data.getId(), k -> data);
    }

    public void addDataToDCache(@NonNull Data data) {
        if (dataCache.size() >= CACHE_SIZE) {
            deleteOldDataFromDCache();
        }
        data.updateTimestamp();
        dataCache.computeIfAbsent(data.getId(), k -> data);
    }

    private void deleteOldDataFromDCache() {
        dataCache.remove(1);
    }

    public Optional<Data> findDataFromDCache(int id) {
        return Optional.ofNullable(dataCache.get(id));
    }

    public Optional<Data> findDataFromDBase(int id) {
        return Optional.ofNullable(dataBase.get(id));
    }

    private Data clientRequestGET(int id) {
        Data data;
        Optional<Data> optionalCacheData = findDataFromDCache(id);
        if (optionalCacheData.isPresent()) {
            data = optionalCacheData.get();
            System.out.println("fromCache");
            data.updateTimestamp();
            return data;
        }

        Optional<Data> optionalBaseData = findDataFromDBase(id);
        if (optionalBaseData.isPresent()) {
            data = optionalBaseData.get();
            System.out.println("fromDBase");
            addDataToDCache(data);
            return data;
        }

        throw new IllegalArgumentException("Data is empty");
    }

    private void clientRequestPOST(@NonNull Data data) {
        addDataToDBase(data);
    }

    public void printCacheState() {
        System.out.println("Current Cache State:");
        for (Map.Entry<Integer, Data> entry : dataCache.entrySet()) {
            Data data = entry.getValue();
            System.out.println("ID: " + data.getId() + ", Value: " + data.getValue() + ", Last Accessed: " + data.getTimestamp());
        }
        System.out.println();
    }
}
