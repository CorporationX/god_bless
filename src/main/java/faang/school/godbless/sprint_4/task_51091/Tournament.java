package faang.school.godbless.sprint_4.task_51091;

import java.util.concurrent.CompletableFuture;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> holdTournament(school, task));
    }

    public School holdTournament(School school, Task task) {
        int taskExecutionTime = task.getDifficulty() * 1000;
        try {
            Thread.sleep(taskExecutionTime);
        } catch (InterruptedException e) {
            System.out.println("Произошло исключение!" + e);
        }
        school.getTeam().forEach(student -> student.addPoints(task.getReward()));
        return school;
    }

    public void determineWinner(School ... schools) {
        School winningSchool = null;
        int winningSchoolTotalPoints = Integer.MIN_VALUE;
        for (School school : schools) {
            int schoolTotalPoints = school.getTotalPoints();
            if (schoolTotalPoints > winningSchoolTotalPoints) {
                winningSchool = school;
                winningSchoolTotalPoints = schoolTotalPoints;
            }
        }
        if (winningSchool == null) {
            System.out.println("Победившей школы нет!");
            return;
        }
        System.out.println("Победила школа \"" + winningSchool.getName()
                + "\"! Общее количество очков команды: " + winningSchoolTotalPoints);
    }
}
