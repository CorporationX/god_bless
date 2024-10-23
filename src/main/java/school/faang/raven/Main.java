package school.faang.raven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static school.faang.raven.Kingdom.sendRaven;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdomSender = new Kingdom("Kingdom Sender");
        Kingdom kingdomReceiver = new Kingdom("Kingdom Reciver");

        ExecutorService executor = Executors.newCachedThreadPool();
        sendRaven(kingdomSender, kingdomReceiver, executor).handle((msg, ex) -> {
            if (ex == null) {
                System.out.println(msg);
            } else {
                System.out.println("Exception in delivery :" + ex.getMessage());
            }
            return null;
        }).join();
        executor.shutdown();
    }
}
