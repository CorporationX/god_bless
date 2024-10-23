package school.faang.BJS2_36827;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final String[] choreTypes = new String[]{"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final int choreNum = 100;

    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Random rand = new Random();
        List<Chore> choreList = new ArrayList<>();

        for(int i = 0; i < choreNum; i++){
            choreList.add(new Chore(choreTypes[rand.nextInt(choreTypes.length)]));
        }

        ExecutorService threadPool = Executors.newCachedThreadPool();

        for(Chore chore:choreList){
            threadPool.submit(chore);
        }
        threadPool.shutdown();
    }
}
