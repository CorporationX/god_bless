package school.faang.extremely_poor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final List<String> CHORES = Arrays.asList("помыть посуду", "подмести пол", "приготовить ужин",
            "вынести мусор", "сделать домашнее задание", "покормить рыбок");

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : CHORES) {
            executor.execute(new Thread(new Chore(chore)));
        }
        executor.shutdown();
    }
}