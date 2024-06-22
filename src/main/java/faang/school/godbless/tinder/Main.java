package faang.school.godbless.tinder;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        UserList userList = getUserList();
        ChatManager chatManager = new ChatManager();

        userList.getOnlineUsers().forEach((user) -> {
            if (user.isReadyToCreateChat()) {
                executorService.execute(() -> chatManager.startChat(user));
            } else {
                executorService.execute(() -> chatManager.waitForChat(user));
            }
        });

        executorService.shutdown();
    }

    private static UserList getUserList() {
        List<User> list = List.of(
                new User(1, "FirstUser", true, true),
                new User(2, "SecondUser", true, false),
                new User(3, "ThirdUser", true, true),
                new User(4, "FourthUser", true, false),
                new User(5, "FifthUser", true, true),
                new User(6, "SixthUser", true, false)
        );

        return new UserList(list);
    }
}
