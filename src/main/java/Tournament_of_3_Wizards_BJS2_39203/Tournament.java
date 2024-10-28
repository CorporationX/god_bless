package Tournament_of_3_Wizards_BJS2_39203;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            school.addPointsToTeam(task.getReward());
            return school;
        });
    }

    public void getWinner(School... schools) {
        School winner = null;
        int maxPoints = 0;
        for (School school : schools) {
            int TotalPoints = school.getTotalPoints();
            if (TotalPoints > maxPoints) {
                maxPoints = TotalPoints;
                winner = school;
            }
        }

        if (winner != null) {
            System.out.println("Winner of Tournament: " + winner.getName() + " with " + maxPoints + " points");
        }
    }
}