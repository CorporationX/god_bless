package faang.school.godbless.lrucache;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, new Data(1, 100));
        cache.put(2, new Data(2, 200));
        cache.put(3, new Data(3, 300));

        cache.get(1);
        cache.put(4, new Data(4, 400));

        cache.printCache();
    }
}