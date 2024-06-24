package faang.school.godbless.multithreading.asynchronousandfuture;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
