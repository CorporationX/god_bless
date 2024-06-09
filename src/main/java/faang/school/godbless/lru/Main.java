package faang.school.godbless.lru;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Data> cacheRequest = new HashMap<>();
        List<Data> list = List.of(
                new Data(1, 1),
                new Data(2, 2),
                new Data(3, 3),
                new Data(4, 4),
                new Data(5, 5),
                new Data(6, 6),
                new Data(7, 7)
        );
        list.stream().forEach(data -> cacheRequest.put(data.getID(), data));
        ServiceCache service = new ServiceCache(cacheRequest);
        service.printAllCache();
        System.out.println("\n");
        service.addNewData(new Data(10, 10));
        service.addNewData(new Data(11, 11));
        service.addNewData(new Data(12, 12));
        service.addNewData(new Data(13, 13));
        service.addNewData(new Data(14, 14));
        service.addNewData(new Data(15, 15));
        service.addNewData(new Data(16, 16));
        service.addNewData(new Data(17, 17));
        service.printAllCache();
    }
}
