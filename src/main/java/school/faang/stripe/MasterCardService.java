package school.faang.stripe;

public class MasterCardService {
    private static final int TIME_TO_PAYMENT = 10_000;
    private static final int TIME_TO_ANALYTICS = 1_000;

    public int collectPayment(int paymentAmount) {
        try {
            Thread.sleep(TIME_TO_PAYMENT);
            System.out.println("Оплата совершена");
            return paymentAmount;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics(int analytic) {
        try {
            Thread.sleep(TIME_TO_ANALYTICS);
            System.out.println("Сводка аналитики");
            return analytic;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
