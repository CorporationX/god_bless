package school.faang.triwizardtournament;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task){

        CompletableFuture<School> taskFuture = CompletableFuture.supplyAsync(() -> {

            try{
                Thread.sleep((task.getDifficulty() * 1000));
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();

            }


        })

    }
}
