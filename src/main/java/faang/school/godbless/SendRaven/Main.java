package faang.school.godbless.SendRaven;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Kingdom kingdom1 = new Kingdom("Север");
        Kingdom kingdom2 = new Kingdom("Железные острова");

        for (int i = 0; i < 10; i++) {
            kingdom1.sendMessage(kingdom2);
        }
    }
}
