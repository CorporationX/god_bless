package faang.school.godbless.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(0, 5);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        while(game.getLives()>0){
            executor.submit(game::update);
        }
        executor.shutdown();

        try{
            if(executor.awaitTermination(1, TimeUnit.SECONDS)){
                System.out.println("Программа завершена");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
