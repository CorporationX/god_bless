package TournamentInKingsLanding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight godrick = new Knight("Годрик сторукий");
        Knight will = new Knight("Уильям дырявое гнездо");

        godrick.addTrial(new Trial(godrick.getName(), "Захватить замок вражин"));
        godrick.addTrial(new Trial(godrick.getName(), "Высвободить принцессу"));

        will.addTrial(new Trial(will.getName(), "Уплыть от стаи крокодилов"));
        will.addTrial(new Trial(will.getName(), "Победить Чёрного всадника"));

        ExecutorService executors = Executors.newFixedThreadPool(2);

        executors.submit(() -> godrick.startTrials());
        executors.submit(() -> will.startTrials());

        executors.shutdown();
        executors.awaitTermination(10, TimeUnit.SECONDS);
    }
}
