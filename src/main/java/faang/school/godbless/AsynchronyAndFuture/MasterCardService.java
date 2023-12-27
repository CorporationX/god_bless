package faang.school.godbless.AsynchronyAndFuture;

public class MasterCardService {
    static int collectPayment() {
        try {
            System.out.println("Операция collectPayment выполнятся в потоке " + Thread.currentThread().getName());
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalystics() {
        try {
            System.out.println("Операция sendAnalystics выполнятся в потоке " + Thread.currentThread().getName());
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
