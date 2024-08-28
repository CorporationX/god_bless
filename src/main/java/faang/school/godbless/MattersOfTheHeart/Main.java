package faang.school.godbless.MattersOfTheHeart;


import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            int userId = i;
            executor.submit(() -> {
                User user = new User( userId);


                Optional<Chat> chatOptional = chatManager.startChat(user, new Random().nextInt(5));
                if (chatOptional.isPresent()) {
                    Chat chat = chatOptional.get();


                    chat.sendMessage(user);

                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    // Пользователь выходит из чата
                    chatManager.leaveChat(user, chat);
                }
            });
        }

        // Завершаем работу пула потоков
        executor.shutdown();
        try {
            // Ждем завершения всех задач
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    System.out.println(chatManager.getChatsWithHisTopCapacity());
    }


}