package faang.school.godbless.send_a_raven;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static faang.school.godbless.send_a_raven.Kingdom.sendRaven;

public class Main {
    public static void main(String[] args) {
        Kingdom starkHouse = new Kingdom("Starks house");
        Kingdom baratheonHouse = new Kingdom("Baratheons house");

        CompletableFuture<String> sendResult = sendRaven(baratheonHouse, starkHouse);
        CompletableFuture<String> sendResult2 = sendRaven(starkHouse, baratheonHouse);




        try {
            sendResult2.get();
            sendResult.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
