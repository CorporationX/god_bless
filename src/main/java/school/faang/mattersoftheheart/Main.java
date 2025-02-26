package school.faang.mattersoftheheart;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private static final ExecutorService REMOVING_EXECUTOR = Executors.newSingleThreadExecutor();
    private static final ChatManager CHAT_MANAGER = new ChatManager();
    private static final UserList USER_LIST = new UserList();
    private static final Random RANDOM = new Random();
    private static final List<User> USERS = List.of(
            new User("Denise Gong"),
            new User("Lyubov Rojas"),
            new User("Yuliya Haque"),
            new User("Nadezhda Chu"),
            new User("Umar Liao"),
            new User("Anil Fernandes"),
            new User("Amanda Coulibaly"),
            new User("Khadija I"),
            new User("Lei Hussein"),
            new User("Sanjay Iqbal"),
            new User("Jesus Guzman"),
            new User("Angela Wen"),
            new User("Patrick Khaled"),
            new User("Nykolai You"),
            new User("Mohan Ismail"),
            new User("Alain Tao"),
            new User("Rina Gupta"),
            new User("Syed Pawar"),
            new User("Munni Le"),
            new User("Alicia Maung")
    );
    private static final int COUNT_OPERATIONS_SET_ONLINE_STATUS = 3;
    private static final boolean IS_USER_ONLINE = false;
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    private static boolean isRunning = true;

    public static void main(String[] args) {
        try {
            USERS.forEach(USER_LIST::addUser);
            USER_LIST.removeUser(USERS.get(RANDOM.nextInt(USERS.size())));
            setStatusesRandomUsers();
            USER_LIST.printAllUsers();

            testChatManager();
        } catch (IllegalArgumentException | InterruptedException e) {
            catchingExceptions(e);
        }
    }

    private static void testChatManager() throws InterruptedException {
        REMOVING_EXECUTOR.submit(() -> {
            while (isRunning) {
                executeWithException(CHAT_MANAGER::endChat);
            }
        });
        USER_LIST.getReadyToChattingUsers().forEach(
                user -> EXECUTOR.submit(() -> executeWithException(() -> CHAT_MANAGER.findChat(user))));

        EXECUTOR.shutdown();
        boolean isTerminatedExecutor = EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT);
        isRunning = false;
        REMOVING_EXECUTOR.shutdown();
        boolean isTerminatedRemovingExecutor = REMOVING_EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT);

        if (isTerminatedExecutor && isTerminatedRemovingExecutor) {
            log.info("All users chatted");
        } else {
            log.warn("Timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
            REMOVING_EXECUTOR.shutdownNow();
        }
    }

    private static void executeWithException(RunnableWithException task) {
        try {
            task.run();
        } catch (InterruptedException e) {
            catchingExceptions(e);
        }
    }

    private static void setStatusesRandomUsers() {
        for (int i = 0; i < COUNT_OPERATIONS_SET_ONLINE_STATUS; i++) {
            int onlineUsers = USER_LIST.getReadyToChattingUsers().size();
            USER_LIST.getReadyToChattingUsers().get(RANDOM.nextInt(onlineUsers)).setOnline(IS_USER_ONLINE);
        }
    }

    private static void catchingExceptions(Exception e) {
        log.error("Thread has been interrupted. Name thread: {}\nException: {}\nStack trace: {}",
                Thread.currentThread().getName(), e, e.getStackTrace());
        Thread.currentThread().interrupt();
        EXECUTOR.shutdownNow();
        REMOVING_EXECUTOR.shutdownNow();
    }
}