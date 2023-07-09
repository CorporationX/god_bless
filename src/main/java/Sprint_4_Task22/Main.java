package Sprint_4_Task22;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        User user = new User("zazozhik", true, true, true, true);
        User user1 = new User("zazozhik", true, true, true, true);
        User user2 = new User("zazozhik", true, false, true, true);
        User user3 = new User("zazozhik", true, true, false, true);
        User user4 = new User("zazozhik", true, true, true, false);
        User user5 = new User("zazozhik", true, true, true, false);

        UserList userList = new UserList();
        userList.addUser(user);
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);
        userList.addUser(user5);

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < userList.getUserList().size()/2; i++) {
            userList.getUserList().get(i).setChatting(true);
        }

        for (User users : userList.getOnlineUsers(user)) {
                executorService.submit(() -> chatManager.startChat(users));
                Thread.sleep(1000);
                chatManager.endChat(users);
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
