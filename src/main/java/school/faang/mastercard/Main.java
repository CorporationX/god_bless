package school.faang.mastercard;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("The current thread is interrupted waiting for the computation to complete: ", e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            log.error("Calculations completed by exception: ", e);
        }
    }
}
