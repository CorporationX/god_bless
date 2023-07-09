package faang.school.godbless.multithreading.async_future;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
