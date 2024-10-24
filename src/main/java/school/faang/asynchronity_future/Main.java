package school.faang.asynchronity_future;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService(2);
        masterCardService.doAll();
    }
}