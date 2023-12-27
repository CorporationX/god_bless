package HarryPotter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        //Запустить задания для каждого студента через CompletableFuture
        CompletableFuture<School> futureSchool = CompletableFuture.supplyAsync(() -> {
            for (Student student : school.getTeam()) {
                try {
                    //Студент выполняет задание до 2х секунд
                    System.out.println("Студент " + student.getName() + " выполняет задание");
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //Случайным образом присваиваем очки студенту
                int reward = (int) (Math.random() * task.getReward());
                student.setPoints(reward);
                System.out.println("Студент " + student.getName() + " получает " + reward + " очков");
            }
            return school;
        });
        //Дождаться выполнения всех заданий
        try {
            futureSchool.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //Вернуть результат
        return futureSchool;
    }
}
