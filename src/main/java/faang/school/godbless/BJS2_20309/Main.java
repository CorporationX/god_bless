package faang.school.godbless.BJS2_20309;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        ExternalDataSource dataSource = new ExternalDataSource();
        LRUCache lruCache = new LRUCache(5);
        lruCache.setExternalDataSource(dataSource);
        Data data1 = new Data(1, "Тестовые данные 1", LocalDateTime.of(2000, 12, 14, 5, 2));
        Data data2 = new Data(2, "Тестовые данные 2", LocalDateTime.of(2005, 5, 22, 1, 45));
        Data data3 = new Data(3, "Тестовые данные 3", LocalDateTime.of(2010, 2, 10, 7, 32));
        Data data4 = new Data(4, "Тестовые данные 4", LocalDateTime.of(2014, 4, 2, 23, 10));
        Data data5 = new Data(5, "Тестовые данные 5", LocalDateTime.of(2013, 1, 6, 15, 7));

        lruCache.put(data1.getId(), data1);
        lruCache.put(data2.getId(), data2);
        lruCache.put(data3.getId(), data3);
        lruCache.put(data4.getId(), data4);
        lruCache.put(data5.getId(), data5);

        System.out.println(lruCache.get(1));

        System.out.println("Размер кэша: " + lruCache.getSize());

        System.out.println("=========");

        System.out.println(lruCache.get(3));

        System.out.println("Размер кэша: " + lruCache.getSize());

        System.out.println("=========");

        System.out.println(lruCache.get(6));

        System.out.println("Размер кэша: " + lruCache.getSize());

        System.out.println("=========");

        System.out.println(lruCache.get(2));

        System.out.println("Размер кэша: " + lruCache.getSize());

        System.out.println("=========");

        System.out.println(lruCache.get(6));

        System.out.println("Размер кэша: " + lruCache.getSize());

        lruCache.print();

    }
}
