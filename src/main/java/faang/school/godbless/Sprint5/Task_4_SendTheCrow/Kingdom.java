package faang.school.godbless.Sprint5.Task_4_SendTheCrow;

import java.util.concurrent.CompletableFuture;

public class Kingdom {
    private String name;
    public Kingdom(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static String sendMessage(Kingdom kingdom) {
        return "Message for kingdom " + kingdom.getName();
    }

    public static CompletableFuture<String> sendRaven(Kingdom sendingKingdom, Kingdom receivingKingdom) {
        boolean notDelivered = false;
        return CompletableFuture.supplyAsync(() -> {
            if (notDelivered) {
                throw new RuntimeException("Сообщение не может быть доставлено");
            }
            return sendMessage(receivingKingdom);
        });
    }

    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Королевство 1");
        Kingdom kingdom2 = new Kingdom("Королевство 2");

        // Отправляем сообщение от королевства 1 к королевству 2
        sendRaven(kingdom1, kingdom2)
                .handle((success, exception) -> {
                    if (exception == null) {
                        System.out.println(sendMessage(kingdom2));
                    } else {
                        System.out.println(exception.getMessage());
                    }
                    return "Доставка завершена";
                }).join();

        // Отправляем сообщение от королевства 2 к королевству 1
        sendRaven(kingdom2, kingdom1)
                .handle((success, exception) -> {
                    if (exception == null) {
                        System.out.println(sendMessage(kingdom1));
                    } else {
                        System.out.println(exception.getMessage());
                    }
                    return "Доставка завершена";
                }).join();
    }
}
