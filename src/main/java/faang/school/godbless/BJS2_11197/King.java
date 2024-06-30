package faang.school.godbless.BJS2_11197;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight firstKnight = new Knight("firstKnight");
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Стреляние из лука"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Пробежка"));


        Knight secondKnight = new Knight("secondKnight");
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Сражение"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Езда на коне"));

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(firstKnight::startTrials);
        service.submit(secondKnight::startTrials);

        service.shutdown();
    }
}
