package school.faang.bjs2_81766_matters_of_heart;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final int MAX_CHAT_THREADS = 5;
    private static final int MAX_ONLINE_USERS = 9;
    private static final Map<Integer, RandomAction> actionIndexes = Map.of(
            0, RandomAction.EXIT,
            1, RandomAction.CREATE_CHAT,
            2, RandomAction.ADD_USER
    );

    public static void main(String[] args) {
        UserList userList = new UserList();
        addStartingUsers(userList);
        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newCachedThreadPool();
        startRandomActionThreads(userList, executorService, chatManager);
        executorService.shutdown();
    }

    private static void startRandomActionThreads(
            UserList userList,
            ExecutorService executorService,
            ChatManager chatManager) {
        for (int i = 0; i < MAX_CHAT_THREADS; i++) {
            executorService.submit(() -> {
                RandomAction nextAction = RandomAction.CREATE_CHAT;
                while (nextAction != RandomAction.EXIT) {
                    switch (nextAction) {
                        case CREATE_CHAT -> createAndExecuteChat(chatManager);
                        case ADD_USER -> addUser(userList);
                        default -> log.warn("Unsupported action {}", nextAction);
                    }
                    nextAction = getNextRandomAction();
                    log.info("Chosen next action: {}", nextAction);
                }
            });
        }
    }

    private static RandomAction getNextRandomAction() {
        return actionIndexes.get(ThreadLocalRandom.current().nextInt(0, actionIndexes.size()));
    }

    private static void addUser(UserList userList) {
        userList.addUser(new User("UserNew" + System.currentTimeMillis(), true, true));
    }

    private static void createAndExecuteChat(ChatManager chatManager) {
        Chat chat = chatManager.createNewChat();
        chat.doChatting();
        chatManager.endChat(chat);
    }

    private static void addStartingUsers(UserList userList) {
        for (int i = 1; i <= MAX_ONLINE_USERS; i++) {
            userList.addUser(new User("UserListed" + i, true, true));
        }
    }
}
