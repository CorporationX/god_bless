package faang.school.godbless.BJS2_24418;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int USERS_COUNT = 20;
        UserList userList = new UserList();
        createUsers(USERS_COUNT).stream()
                .forEach(userList::addUser);
        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executor = Executors.newFixedThreadPool(8);


        userList.getUsers().get(2).setOnline(true);
        userList.getUsers().get(2).setWantToChat(true);
        executor.submit(() -> chatManager.startChat(userList.getUsers().get(2)));
        sleep(6000);
        userList.getUsers().get(5).setOnline(true);
        userList.getUsers().get(5).setWantToChat(true);
//        userList.getUsers().get(7).setOnline(true);
//        userList.getUsers().get(7).setWantToChat(true);


        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<User> createUsers(int usersCount) {
        return IntStream.range(0, usersCount)
                .mapToObj(i -> new User(i, "User_" + i))
                .toList();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
