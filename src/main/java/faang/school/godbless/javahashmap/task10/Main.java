package faang.school.godbless.javahashmap.task10;

public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();

        lruCache.add(  new Data(15));
        lruCache.add( new Data(10));
        lruCache.add( new Data(5));
        lruCache.add( new Data(5));
        lruCache.add( new Data(5));

        int keyToGet = 3;
        Data result = lruCache.get(keyToGet);

        if (result != null) {
            System.out.println("Data ключа " + keyToGet + ": " + result);
        } else {
            System.out.println("Ключ " + keyToGet + " не найден в кэшэ");
        }

        System.out.println("Состояние кэша: " + lruCache.getCache());

    }
}