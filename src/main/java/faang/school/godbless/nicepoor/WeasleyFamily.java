package faang.school.godbless.nicepoor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = List.of(
                new Chore("Clean house"),new Chore("send an email"), new Chore("Go to gym"),
                new Chore("Clean house"),new Chore("send an email"), new Chore("Go to gym"),
                new Chore("Clean house"),new Chore("send an email"), new Chore("Go to gym"),
                new Chore("Clean house"),new Chore("send an email"), new Chore("Go to gym"),
                new Chore("Clean house"),new Chore("send an email"), new Chore("Go to gym")
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        chores.forEach(executorService::submit);
        executorService.shutdown();
    }
}
