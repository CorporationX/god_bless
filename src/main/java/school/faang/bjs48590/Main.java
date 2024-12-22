package school.faang.bjs48590;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleys = new WeasleyFamily(new Chore[]{
                new Chore("Помыть посуду"),
                new Chore("Подмести пол"),
                new Chore("Приготовить ужин"),
                new Chore("Постирать белье"),
                new Chore("Погладить одежду"),
                new Chore("Убрать в комнате"),
                new Chore("Полить цветы"),
                new Chore("Сходить за продуктами"),
                new Chore("Почистить окна"),
                new Chore("Выгулять собаку")
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        Arrays.stream(weasleys.chores())
                .forEach(executorService::submit);

        executorService.shutdown();
    }
}
