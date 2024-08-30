package faang.school.godbless.BJS2_24935;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (ExecutionException ee) {
            System.out.println("исключение при выполнении: " + ee.getMessage());
            Throwable cause = ee.getCause();
            if (cause instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) cause;
                System.out.println("исходное исключение: " + re.getMessage());
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            System.out.println("Поток был прерван");
        }
    }
}
