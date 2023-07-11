package faang.school.godbless.sendCrow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Kingdom starks = new Kingdom("Starks");
        Kingdom greyjoies = new Kingdom("Greyjoies");
        Kingdom lannisters = new Kingdom("Lannisters");
        Kingdom targariens = new Kingdom("Targariens");

        sendRaven(starks, greyjoies, "Hello!");
        sendRaven(lannisters, targariens, "");
    }

    public static void sendRaven(Kingdom sender, Kingdom getter, String message){
        CompletableFuture<String> sendFuture = CompletableFuture.supplyAsync(() -> sender.sendMessage(getter, message))
                .handle((words, exception) -> {
                if(words != null){
                    return words;
                } else {
                    return exception.getMessage();
                }
                });

        try {
            System.out.println(sendFuture.get());
        } catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
