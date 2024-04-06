package faang.school.godbless.lrucache;

public class Main {

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
        System.out.println("test put data");
        Data data = new Data(1, 1);
        lruCache.put(data);
        lruCache.printCache();
        System.out.println("--------------------------");
        System.out.println();

        System.out.println("Test + 2 data");
        Data data2 = new Data(2, 2);
        Data data3 = new Data(3, 3);
        lruCache.put(data2);
        lruCache.put(data3);
        lruCache.printCache();

        System.out.println("test add 4 data, expected 2 3 4");
        Data data4 = new Data(4, 4);
        lruCache.put(data4);
        lruCache.printCache();

        System.out.println("test get data2");
        data2 = lruCache.getData(2);
        System.out.println(data2);

        System.out.println("test put data5 expected 4 2 5");
        Data data5 = new Data(5, 5);
        lruCache.put(data5);
        lruCache.printCache();

        System.out.println("Test get data3 from ALL_DATA + expected 2 5 3");
        data3 = lruCache.getData(3);
        System.out.println(data3);
        lruCache.printCache();
    }
}
