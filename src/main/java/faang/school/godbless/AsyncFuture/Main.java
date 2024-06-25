package faang.school.godbless.AsyncFuture;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        try{
            masterCardService.doAll();
        } catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }

    }
}
