package faang.school.godbless.task_17;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LRUOptimized lru = new LRUOptimized();

        lru.put(new Data(1, 1));
        System.out.println("add 1: " + printCache(lru));

        lru.put(new Data(2, 2));
        System.out.println("add 2: " + printCache(lru));

        lru.get(1);
        System.out.println("get 1: " + printCache(lru));

        lru.put(new Data(3, 3));
        System.out.println("add 3: " + printCache(lru));

        lru.get(2);
        System.out.println("get 2: " + printCache(lru));

        lru.put(new Data(4, 4));
        System.out.println("add 4: " + printCache(lru));

        lru.get(1);
        System.out.println("get 1: " + printCache(lru));

        lru.get(2);
        System.out.println("get 2: " + printCache(lru));

        lru.get(3);
        System.out.println("get 3: " + printCache(lru));

    }

    public static String printCache(LRUOptimized lru) {
        List<Data> ids = lru.getCache();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ids.size(); i++) {
            if (i == ids.size() - 1) builder.append(ids.get(i).getId());
            else builder.append(ids.get(i).getId()).append(" -> ");
        }
        return builder.toString();
    }
}
