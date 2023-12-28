package faang.school.godbless.three_wizard;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        //List<Student> students = school.getTeam();
        // как лучше делать? Как сейчас или создавать отдельную переменную(выше строка) и использовать ее?
        ExecutorService executor = Executors.newFixedThreadPool(school.getTeam().size());
        CompletableFuture<School> future = CompletableFuture.supplyAsync(() -> {
            int points = task.getReward();//<-вот так или лучше было бы прям в лямбде вызвать метод таска?
            school.getTeam().forEach(student -> student.setPoints(points));
            return school;
        }, executor);
        executor.shutdown();
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future);
        try {
            allOf.get(3, TimeUnit.MINUTES);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
// либо я тему никак понять не могу, либо задания непонятные. Что в WOW не пог понять, куда засунуть thenApply(),
// что тут не пойму, куда  thenAccept()
        return future;
    }
}
