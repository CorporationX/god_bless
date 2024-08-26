package heart;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int USERS_COUNT = 30;
    private static final int POOL_SIZE = 10;
    private static final String[] PHRASES = {"Welcome to the club buddy!",
            "I'm performance artist", "Deep dark fantasies", "Oh shit i'm sorry",
            "Three hundred bucks", "Dungeon master?", "Leather man?"};

    public static void main(String[] args) throws InterruptedException {
        UserList userList = initUserList();
        ChatManager chatManager = new ChatManager(userList);
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            userList.getOnlineUsers().forEach(user -> executor.execute(() -> {
                chatManager.startChat(user);
                for (int i = 0; i < ThreadLocalRandom.current().nextInt(8) + 3; i++) {
                    if (user.getCurrentChat() != null) {
                        user.sendMessage(new Message(PHRASES[ThreadLocalRandom.current().nextInt(PHRASES.length)]));
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            throw new RuntimeException(e);
                        }

                    }
                }
                chatManager.endChat(user.getCurrentChat(), user);
            }));
            executor.shutdown();
            if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.info("Finished");
            } else {
                log.error("Time out");
            }
        }
        chatManager.getArchivedChats().forEach(Chat::printChatHistory);
    }

    private static UserList initUserList() {
        return new UserList(IntStream.range(0, USERS_COUNT)
                .mapToObj(i -> new User("User" + i))
                .toList());
    }
}
