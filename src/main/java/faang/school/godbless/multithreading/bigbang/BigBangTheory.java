package faang.school.godbless.multithreading.bigbang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;

@Slf4j
public class BigBangTheory {

    public static void main(String[] args) {
        var threadPool = Executors.newFixedThreadPool(4);
        threadPool.execute(new Task("Sheldon", "Theory"));
        threadPool.execute(new Task("Leonard", "Modeling an experiment"));
        threadPool.execute(new Task("Howard", "Tool development"));
        threadPool.execute(new Task("Rajesh", "Data analysis"));
        threadPool.shutdown();
    }
}
