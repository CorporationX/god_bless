package faang.school.godbless.javaHashMap.LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<Integer, Data> dataStructure;

    public Main() {
        dataStructure = new HashMap<>();

        addData(new Data(1, "int"));
        addData(new Data(2, "byte"));
        addData(new Data(3, "short"));
        addData(new Data(4, "long"));
        addData(new Data(5, "double"));
        addData(new Data(6, "float"));
        addData(new Data(7, "char"));
        addData(new Data(8, "boolean"));
        addData(new Data(9, "String"));
        addData(new Data(10, "List"));
        addData(new Data(11, "Map"));
        addData(new Data(12, "Object"));
    }

    public static void main(String[] args) {
        Main dataService = new Main();
        Cache lruCache = new Cache(dataService);

        System.out.println("LRU Cache at start point:");
        lruCache.printCache();

        System.out.println("\n---------------------------------");

        System.out.println("\nGetting 10 (MAX_SIZE = 10) records of data:");

        System.out.println(lruCache.getData(1));
        System.out.println(lruCache.getData(2));
        System.out.println(lruCache.getData(3));
        System.out.println(lruCache.getData(4));
        System.out.println(lruCache.getData(5));
        System.out.println(lruCache.getData(6));
        System.out.println(lruCache.getData(7));
        System.out.println(lruCache.getData(8));
        System.out.println(lruCache.getData(9));
        System.out.println(lruCache.getData(10));

        System.out.println("\n---------------------------------");

        System.out.println("\nLRU Cache at this point:\"");
        lruCache.printCache();

        System.out.println("\n---------------------------------");

        System.out.println("\nGetting 4 (MAX_SIZE = 10) records of data:");

        System.out.println(lruCache.getData(1));
        System.out.println(lruCache.getData(2));
        System.out.println(lruCache.getData(11));
        System.out.println(lruCache.getData(12));

        System.out.println("\n---------------------------------");

        System.out.println("\nLRU Cache at this point:\"");
        lruCache.printCache();
    }

    public void addData(Data data) {
        dataStructure.put(data.getId(), data);
        data.updateTimestamp();
    }

    public Data getData(int id) {
        return dataStructure.get(id);
    }
}
