package faang.school.godbless.games.of.thrones;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Kingdom kingdom1 = new Kingdom("stark");
        Kingdom kingdom2 = new Kingdom("martell");

        kingdom1.sendMessage(kingdom1);
        System.out.println(kingdom1.sendRaven(kingdom1, kingdom2));

    }
}
