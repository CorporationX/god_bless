package asynchrony_and_the_future;

import java.util.concurrent.ExecutionException;

public class Main {
    /**
     * The main entry point of the application. Initializes the MasterCardService
     * and performs all operations including payment collection and sending analytics.
     *
     * @param args Command line arguments
     * @throws ExecutionException if there is an error during the execution of a task
     * @throws InterruptedException if the current thread is interrupted while waiting
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
