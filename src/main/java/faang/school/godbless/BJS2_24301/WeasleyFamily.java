package faang.school.godbless.BJS2_24301;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Chore[] chores = new Chore[]{
                new Chore("Помыть посуду"), new Chore("Постирать белье"),
                new Chore("Погладить рубашки"), new Chore("Вымыть полы"),
                new Chore("Приготовить ужин")
        };
        var executorService = Executors.newCachedThreadPool();

        Stream.of(chores).forEach(executorService::execute);

        executorService.shutdown();
        if (executorService.awaitTermination(10, TimeUnit.SECONDS))
            System.out.println("Все дела выполнены");
    }
}
