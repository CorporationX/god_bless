package faang.school.godbless.multithreading.matters_heart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Tinder {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(IntStream.rangeClosed(1, 10)
                .boxed()
                .map(i -> new User("User" + i, true))
                .toList());
        UserList userList = new UserList(users);
        ChatManager chatManager = new ChatManager(new ArrayList<>(), userList);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(0)));
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(1)));
        service.shutdown();
    }
}
