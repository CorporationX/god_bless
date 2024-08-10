package faang.school.godbless;

public class Application {
    private final static int CACHE_SIZE = 3;

    public static void main(String[] args) {
        try {
            LRUCache cache = new LRUCache(CACHE_SIZE);

            Data data1 = new Data("Data 1");
            Thread.sleep(500); // To make difference timestamp
            Data data2 = new Data("Data 2");
            Thread.sleep(500); // To make difference timestamp
            Data data3 = new Data("Data 3");
            Thread.sleep(500); // To make difference timestamp
            Data data4 = new Data("Data 4");

            cache.addData(data1);
            cache.addData(data2);
            cache.addData(data3);

            cache.print();

            System.out.println("Get Data 1 by ID: \n    " + cache.getData(data1.getId()));

            cache.addData(data4);

            cache.print();

            Data fromCacheData2 = cache.getData(data2.getId());
            System.out.println("Get Data 2 by ID: \n    " + (fromCacheData2 != null ? fromCacheData2 : "No found"));

        } catch (IllegalArgumentException | InterruptedException error) {
            System.out.println("Error: \n   " + error.getMessage());
        }
    }
}