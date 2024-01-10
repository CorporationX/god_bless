package faang.school.godbless.alexbulgakoff.multithreading.async.future;

import lombok.SneakyThrows;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }

}
