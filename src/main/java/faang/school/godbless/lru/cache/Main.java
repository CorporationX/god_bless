package faang.school.godbless.lru.cache;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache();

        Data data1 = new Data("10");
        Data data2 = new Data("20");
        Data data3 = new Data("30");
        Data data4 = new Data("40");
        Data data5 = new Data("50");

        lru.put(data1);
        lru.put(data2);
        lru.put(data3);
//        lru.get(1);
//        lru.get(0);
        lru.put(data4);
        lru.put(data5);
        lru.get(1);
        lru.put(data4);
        lru.put(data4);
        lru.put(data4);
//        lru.put(data1);
//        lru.put(data1);
        System.out.println("Cache:");

        for (Map.Entry<Integer, Node> item : lru.cache.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue().getData().getValue());
        }

        System.out.println("Nodelist:");

        Node curr = lru.getHead();

        while (curr != null) {
            System.out.println(curr.getData().getValue());
            curr = curr.next;
        }
    }
}
