package faang.school.godbless.task.multithreading.concurrency.work.stands;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_FILES = 3;

    private static final MarketingResources marketingResources = new MarketingResources();
    private static final DesignResources designResources = new DesignResources();

    public static void main(String[] args) {
        addDefaultFiles();
        DesignDepartment designDepartment = new DesignDepartment(() -> {
            marketingResources.showAllFiles();
            sleep();
            designResources.addFile("New design file");
        });
        MarketingDepartment marketingDepartment = new MarketingDepartment(() -> {
            marketingResources.addFile("New marketing file");
            sleep();
            designResources.showAllFiles();
        });
        designDepartment.start();
        marketingDepartment.start();
    }

    private static void addDefaultFiles() {
        IntStream.rangeClosed(1, NUMBER_OF_FILES)
                .forEach(i -> {
                    marketingResources.addFile("Marketing file " + i);
                    designResources.addFile("Design file " + i);
                });
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
