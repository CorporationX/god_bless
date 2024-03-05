package faang.school.godbless.async_and_future;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService(MasterCardService.collectPayment(),MasterCardService.sendAnalytics());
        service.doAll();
    }
}
