package faang.school.godbless.async_and_future;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService(100, 20);
        service.doAll();
    }
}
