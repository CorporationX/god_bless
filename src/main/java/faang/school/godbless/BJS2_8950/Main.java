package faang.school.godbless.BJS2_8950;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataBase dataBase = new DataBase();
        dataBase.addData(new Data(1, "value1", LocalDateTime.now()));
        dataBase.addData(new Data(2, "value2", LocalDateTime.now()));
        dataBase.addData(new Data(3, "value3", LocalDateTime.now()));
        dataBase.addData(new Data(4, "value4", LocalDateTime.now()));

        Cache cache = new Cache(3, dataBase);
        cache.addData(dataBase.getData(1));
        Thread.sleep(100);
        cache.addData(dataBase.getData(2));
        Thread.sleep(100);
        cache.addData(dataBase.getData(3));
        cache.printStatus();
        Thread.sleep(100);
        System.out.println();
        System.out.println(cache.getData(4));
        System.out.println();
        cache.printStatus();
        System.out.println();
        System.out.println(cache.getData(2));
        cache.printStatus();
        System.out.println();
    }


}
