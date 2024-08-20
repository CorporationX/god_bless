package faang.school.godbless.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        Knight leo = new Knight("LEO");
        Knight test = new Knight("TEST");

        Trial suicideLeo = new Trial("try to suicide", leo.getName());
        Trial jumpLeo = new Trial("jump through black sea", leo.getName());
        Trial watchLeo = new Trial("watch after the sun", leo.getName());

        Trial sleepTest = new Trial("just sleep", test.getName());
        Trial eatTest = new Trial("just eat", test.getName());
        Trial chillTest = new Trial("just chill", test.getName());

        leo.addTrial(suicideLeo);
        leo.addTrial(jumpLeo);
        leo.addTrial(watchLeo);

        test.addTrial(sleepTest);
        test.addTrial(eatTest);
        test.addTrial(chillTest);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        leo.startTrials(executorService);
        test.startTrials(executorService);

        executorService.shutdown();
    }
}
