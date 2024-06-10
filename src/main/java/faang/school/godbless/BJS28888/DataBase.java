package faang.school.godbless.BJS28888;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static final int CACHE_SIZE = 3;
    private Map<Integer, Data> dataBase = new HashMap<>();
    private LRUCache cache = new LRUCache(CACHE_SIZE);

    public void addElement(int id, String value) {
        if (dataBase.containsKey(id)) {
            System.out.println("An element with this id already exists int the DB");
        } else {
            Data newElement = new Data(id, value);
            dataBase.put(id, newElement);
            System.out.println("Element with id " + id + " added successfully in the DB");
        }
    }

    public Data getElement(int id) {
        if (cache.getCache().containsKey(id)) {
            return cache.getElement(id);
        } else if (!dataBase.containsKey(id)) {
            throw new RuntimeException("An element with this id doesn't exist int the DB");
        }
        return cache.addElement(dataBase.get(id));
    }

    public void printCache() {
        cache.printCache();
    }

}
