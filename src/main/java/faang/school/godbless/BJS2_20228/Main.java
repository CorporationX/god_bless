package faang.school.godbless.BJS2_20228;

import java.util.LinkedHashMap;
import java.util.Map;


public class Main {
    private static final int CACHE_SIZE = 3;
    private static final int HASHMAP_INIT_CAPACITY = 16;
    private static final float HASHMAP_LOAD_FACTOR = 0.75f;
    private static final boolean CACHE_ACCESS_ORDER = true;

    public Map<Long, Data> cache = new LinkedHashMap<>(HASHMAP_INIT_CAPACITY, HASHMAP_LOAD_FACTOR, CACHE_ACCESS_ORDER) {

        @Override
        protected boolean removeEldestEntry(Map.Entry<Long, Data> eldest) {
            return cache.size() > CACHE_SIZE;
        }
    };

    public void addData(Data data) {
        data.updateTimestamp();
        cache.put(data.getId(), data);
    }

    public Data getData(Long id) {
        if (cache.containsKey(id)) {
            Data data = cache.get(id);
            data.updateTimestamp();
            return data;
        } else {
            throw new IllegalArgumentException("This ID does not exist");
        }
    }

    public void viewCache() {
        for (Map.Entry<Long, Data> entry : cache.entrySet()) {
            Long id = entry.getKey();
            Data data = entry.getValue();
            System.out.println(id + ": " + data);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main application = new Main();
        Data one = new Data(1L, "one");
        Data two = new Data(2L, "two");
        Data three = new Data(3L, "three");
        Data four = new Data(4L, "four");
        application.addData(one);
        Thread.sleep(100);
        application.addData(two);
        Thread.sleep(100);
        application.addData(three);
        application.viewCache();
        System.out.println();

        Thread.sleep(100);
        application.addData(four);
        application.viewCache();
        System.out.println();

        Thread.sleep(1000);
        System.out.println(application.getData(3L));
        application.viewCache();
    }
}

