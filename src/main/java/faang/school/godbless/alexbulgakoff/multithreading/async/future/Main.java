package faang.school.godbless.alexbulgakoff.multithreading.async.future;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }

}
