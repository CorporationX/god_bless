package tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        Knight sam = new Knight("Sam");
        Knight artem = new Knight("Artem");
        sam.addTrial(new Trial(sam.getName(), "trialBySam1"));
        sam.addTrial(new Trial(sam.getName(), "trialBySam2"));
        artem.addTrial(new Trial(artem.getName(), "trialByArtem1"));
        sam.addTrial(new Trial(artem.getName(), "trialByArtem2"));
        List<Knight> knights = List.of(sam,artem);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(Knight knight: knights){
            executorService.submit(() -> knight.startTrial());
        }
        executorService.shutdown();
        if(executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)){
            System.out.println("Игра окончена");
        }else{
            executorService.shutdownNow();
        }
    }
}
