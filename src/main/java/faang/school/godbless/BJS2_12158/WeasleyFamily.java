package faang.school.godbless.BJS2_12158;

import ch.qos.logback.core.encoder.EchoEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final List<Chore> chores = new ArrayList<>();

    public static void main(String[] args) {


        chores.add(new Chore("анжуманя"));
        chores.add(new Chore("пресс качат"));
        chores.add(new Chore("бегит"));
        chores.add(new Chore("турник"));


        ExecutorService executorService = Executors.newCachedThreadPool();

        chores.forEach(executorService::submit);

        executorService.shutdown();
    }
}
