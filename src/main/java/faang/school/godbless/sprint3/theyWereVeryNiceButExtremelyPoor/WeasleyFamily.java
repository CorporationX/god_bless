package faang.school.godbless.sprint3.theyWereVeryNiceButExtremelyPoor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        List<Chore> chores = new ArrayList<>();

        chores.add(new Chore("first task"));
        chores.add(new Chore("second task"));
        chores.add(new Chore("third task"));
        chores.add(new Chore("fourth task"));
        chores.add(new Chore("fifth task"));
        chores.add(new Chore("sixth task"));
        chores.add(new Chore("seventh task"));
        chores.add(new Chore("eight task"));

        ExecutorService executorService = Executors.newCachedThreadPool();

        chores.forEach(executorService::execute);

        executorService.shutdown();

    }
}
