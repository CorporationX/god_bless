package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatRunner {

    public static void main(String[] args) {
        UserList userList = new UserList();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            users.add(new User(i, "User " + i, true, false));
        }

        for (int i = 0; i < 10; i++) {
            User user = users.get(i);
            List<User> likedUsers = new ArrayList<>(users);
            likedUsers.remove(user);
            user.setLikedUsers(likedUsers);
            userList.addUser(user);
        }

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            User chatUser = chatManager.getOnlineUsers().get(i);

            Runnable chatTask = () -> chatManager.startChat(chatUser);
            executorService.submit(chatTask);
            Runnable endTask = () -> chatManager.endChat(chatUser);
            executorService.submit(endTask);
        }

        executorService.shutdown();
    }
}
