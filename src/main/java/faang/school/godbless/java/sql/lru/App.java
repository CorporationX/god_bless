package faang.school.godbless.java.sql.lru;

public class App {
    public static void main(String[] args) {

        LruService lruService = new LruService();

        Data data1 = new Data(1, "Dog", "2024-08-14T11:55:30");
        Data data2 = new Data(2, "Dog2", "2024-08-16T11:55:30");
        Data data3 = new Data(3, "Dog3", "2024-08-05T11:55:30");
        Data data4 = new Data(4, "Dog4", "2024-08-12T11:55:30");
        Data data5 = new Data(5, "Dog5", "2024-08-03T11:55:30");
        Data data6 = new Data(6, "Dog6", "2024-08-15T11:55:30");
        Data data7 = new Data(7, "Cat");

        try {
            lruService.addNewDataInCache(data1);
            lruService.addNewDataInCache(data1);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        lruService.addNewDataInCache(data2);
        lruService.addNewDataInCache(data3);
        lruService.addNewDataInCache(data4);
        lruService.addNewDataInCache(data5);
        lruService.addNewDataInCache(data6);
        lruService.getDataByDataId(data7);

        lruService.printCacheState();

    }
}
