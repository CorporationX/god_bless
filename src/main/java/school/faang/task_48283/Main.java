package school.faang.task_48283;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        House house = addHouseData();
        ExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
//            executor.submit(house.collectFood());
        }
    }

    private static House addHouseData() {

        return new House(new ArrayList<>());
    }
}
