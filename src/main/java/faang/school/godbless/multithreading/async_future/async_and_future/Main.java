package faang.school.godbless.multithreading.async_future.async_and_future;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }


}
