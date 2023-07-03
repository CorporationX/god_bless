package faang.school.godbless.asyncronicity_and_future;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
