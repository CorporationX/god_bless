package faang.school.godbless.lruCache;


public class Main {



    public static void main(String[] args) {

        try {
            CacheRepository cacheRepository = new CacheRepositoryImpl();
            CacheService cacheService = new CacheServiceImpl(cacheRepository);

            Data data1 = Data.builder()
                    .id(1)
                    .value("value 1")
                    .build();

            Data data2 = Data.builder()
                    .id(2)
                    .value("value 2")
                    .build();

            Data data3 = Data.builder()
                    .id(3)
                    .value("value 3")
                    .build();

            Data data4 = Data.builder()
                    .id(4)
                    .value("value 4")
                    .build();

            Data data5 = Data.builder()
                    .id(5)
                    .value("value 5")
                    .build();

            cacheService.create(data1.getId(), data1.getValue());
            Thread.sleep(100);
            cacheService.create(data2.getId(), data2.getValue());
            Thread.sleep(100);
            cacheService.create(data3.getId(), data3.getValue());
            Thread.sleep(100);
            cacheService.create(data4.getId(), data4.getValue());
            Thread.sleep(100);
            cacheService.create(data5.getId(), data5.getValue());
            Thread.sleep(100);
            cacheService.create(data1.getId(), data1.getValue());


            Data foundedData = cacheService.get(4);
            Data foundedData2 = cacheService.get(10);
            Data foundedData3 = cacheService.get(2);

        } catch (Exception e) {
            System.out.println("message error: " + e.getMessage());
        }
    }
}
