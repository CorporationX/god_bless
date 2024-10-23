package school.faang.asynchfuture;

public class Application {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
