package faang.school.godbless.multithreading.matters_heart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Tinder {
    public static void main(String[] args) throws InterruptedException {
        List<User> users = new ArrayList<>(IntStream.rangeClosed(1, 10)
                .boxed()
                .map(i -> new User("User" + i, true))
                .toList());
        UserList userList = new UserList(users);
        ChatManager chatManager = new ChatManager(new ArrayList<>(), userList);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(0)));
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(1)));
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(2)));
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(3)));
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(4)));
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(5)));
        service.execute(() -> chatManager.startChat(userList.getOnlineUsers().get(5)));
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        chatManager.endChat(userList.getOnlineUsers().get(0));
    }
}
