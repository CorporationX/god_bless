package asyncfuture;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        multipleMethodCall(masterCardService, 3);
    }

    public static void multipleMethodCall(MasterCardService cardService, int count) {
        for (int i = 0; i < count; i++) {
            cardService.doAll();
        }
    }
}