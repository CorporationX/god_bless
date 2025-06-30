package school.faang.bjs2_82485;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        final int payment = 5_000;
        final int analytics = 17_000;
        masterCardService.doAll(payment, analytics);
    }
}