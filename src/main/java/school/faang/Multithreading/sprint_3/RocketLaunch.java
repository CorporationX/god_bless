package school.faang.Multithreading.sprint_3;

import lombok.Getter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class RocketLaunch {
    private String name;
    private LocalTime launchTime;

    public RocketLaunch() {

    }

    public RocketLaunch(String name, LocalTime launchTime) {
        validateParameters(name, launchTime);

        this.name = name;
        this.launchTime = launchTime;
    }

    private void validateParameters(String name, LocalTime launchTime) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Ракета без имени");
//        }else if(launchTime < 0){
//            throw new IllegalArgumentException("Некорректное время запуска");
        }
    }


    public void planRocketLaunches(List<RocketLaunch> launches) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<RocketLaunch> finishedLaunches = new ArrayList<>();

        for (RocketLaunch rocketLaunch : launches) {
//            long millis =  rocketLaunch.getLaunchTime().getSecond() * 1000;
            executor.execute(rocketLaunch::launch);
            finishedLaunches.add(rocketLaunch);
//            try {
//                Thread.sleep(millis);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        for (RocketLaunch finishedLaunch : finishedLaunches) {
            launches.remove(finishedLaunch);
        }

        if (completedLaunches(launches)) {
            executor.shutdown();
            awaitTermination(executor);
            System.out.println(System.currentTimeMillis());
        }
    }

    public void launch() {
        try {
            System.out.print(Thread.currentThread().getName());
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ракета " + this.name + " запускается");
    }

    private boolean completedLaunches(List<RocketLaunch> launches) {
        return launches.isEmpty();
    }

    private void awaitTermination(ExecutorService executor) {
        try {
            if (executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Все запуски завершены.");
            } else {
                System.out.println("Некоторые запуски не завершились в указанный срок.");
            }
        } catch (InterruptedException e) {
            System.err.println("Ошибка при ожидании завершения задач: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}
