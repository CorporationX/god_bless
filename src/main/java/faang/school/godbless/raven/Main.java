package faang.school.godbless.raven;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom = new Kingdom("Kingdom");
        Kingdom kingdom1 = new Kingdom("Kingdom1");
        sendRaven(kingdom, kingdom1);
    }
    public static void sendRaven(Kingdom sender, Kingdom receiver){
        CompletableFuture<String> future= CompletableFuture.supplyAsync((()->sender.sendMessage(receiver)));
        var result = future.handle(( msg, ex) -> {
            if(ex!=null){
                System.out.println("Raven is dead!");
            }
            return msg;
        }).join();
        System.out.println(result);
    }
}
