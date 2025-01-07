package school.faang.task_51160;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(task.getDifficulty() * 1000);
                int qualityPointsTeam = school.getTotalPoints();
                int pointForOneStudent = task.getReward() / school.getTeam().size();
                for (Student student : school.getTeam()) {
                    student.setPoints(student.getPoints() + pointForOneStudent);
                }
                System.out.println("Количество баллов команды '" + school.getName()
                        + "' до начисления баллов: " + qualityPointsTeam + ". К начислению: " + task.getReward()
                        + ". Cумма баллов команды: " + school.getTotalPoints());
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            return school;
        });
    }
}
