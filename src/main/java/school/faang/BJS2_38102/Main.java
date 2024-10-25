package school.faang.BJS2_38102;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();

        try{
            service.doAll();
        } catch (InterruptedException e){
            System.err.println("InterruptedException occurred: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.err.println("ExecutionException occurred: " + e.getMessage());
        }
    }
}