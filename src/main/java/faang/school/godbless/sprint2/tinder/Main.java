package faang.school.godbless.sprint2.tinder;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
    private static final int POOL_SIZE = 4;
    private static final int USERS_COUNT = 99;
    private static final int SLEEP_MILLIS = 2000;
    private static final int SLEEP_DIVISOR = 30;
    private static final int ONLINE_DIVISOR = 3;

    @SneakyThrows
    public static void main(String[] args) {
        ChatList chatList = new ChatList(new ArrayList<>());
        UserList userList = new UserList(createUsers());
        ChatManager manager = new ChatManager(userList, chatList);
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

        for (User user : userList.getUsers()) {
            if (user.getId() % SLEEP_DIVISOR == 0) {
                Thread.sleep(SLEEP_MILLIS);
            }
            executorService.submit(() -> manager.startChat(user));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(USERS_COUNT / POOL_SIZE, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        }
        catch (InterruptedException e) {
            log.error(e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        printChatState(manager.getChatList());
        printWaitingUsers(userList);
    }

    public static List<User> createUsers() {
        return IntStream.range(0, USERS_COUNT)
                .mapToObj((i) -> {
                    boolean isOnline = i % ONLINE_DIVISOR == 0;
                    return new User(i, "User_" + i, false, isOnline);
                })
                .toList();
    }

    public static void printChatState(ChatList chatList) {
        System.out.println("Chat state: ");
        chatList.getChatList().forEach((System.out::println));
    }

    public static void printWaitingUsers(UserList userList) {
        System.out.println("Waiting user state: ");
        userList.getWaitingChatUsers().forEach((System.out::println));
    }
}
