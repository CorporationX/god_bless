package faang.school.godbless.BJS2_14365;

import java.util.concurrent.*;

public class Tournament {
    private int random;

    public CompletableFuture<School> startTask(School school, Task task) {
        double reward = task.getReward();
        ExecutorService service = Executors.newFixedThreadPool(school.getTeam().size());
        CompletableFuture<School> schoolFuture = CompletableFuture.supplyAsync(() -> {
            divideReward(reward, school);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            return school;
        }, service);
        service.shutdown();
        return schoolFuture;
    }

    private void divideReward(double reward, School school) {
        double tempReward = reward;
        double earnedPoints;
        int quantity = school.getTeam().size();
        int i = -1;
        while (++i < school.getTeam().size()) {
            random = ThreadLocalRandom.current().nextInt(quantity);
            System.out.println("random is " + random);
            earnedPoints = tempReward / random;
            school.getTeam().get(i).earnPoints(earnedPoints);
            tempReward -= earnedPoints;
            quantity--;
        }
    }
}
