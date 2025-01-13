package asynchrony_and_future;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        masterCardService.doAll();
    }
}
