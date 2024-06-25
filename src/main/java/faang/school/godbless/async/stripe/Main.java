package faang.school.godbless.async.stripe;

public class Main {

    public static void main(String[] args) {
        var masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
