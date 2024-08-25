package faang.school.godbless.javasynchronized.task7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tinder {
    public static void main(String[] args) {
        User user1 = new User("RachelQu", true);
        User user2 = new User("BrianDavid", false);
        User user3 = new User("HanKhan", true);
        User user4 = new User("LeonardoDing", true);
        User user5 = new User("AdrianXue", true);
        User user6 = new User("ManojBa", true);
        User user7 = new User("MáriaDiallo", true);
        User user8 = new User("ThomasDuong", true);


        UserList userList = new UserList();
        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);
        userList.addUser(user5);
        userList.addUser(user6);
        userList.addUser(user7);
        userList.addUser(user8);

        ChatManager chatManager = new ChatManager(userList);


        ExecutorService executorService = Executors.newFixedThreadPool(8);
        executorService.execute(() -> chatManager.startChat(user1));
        executorService.execute(() -> chatManager.startChat(user2));
        executorService.execute(() -> chatManager.startChat(user3));
        executorService.execute(() -> chatManager.startChat(user4));
        executorService.execute(() -> chatManager.startChat(user5));
        executorService.execute(() -> chatManager.startChat(user6));
        executorService.execute(() -> chatManager.startChat(user7));
        executorService.execute(() -> chatManager.startChat(user8));
        executorService.execute(() -> chatManager.endChat(chatManager.getChats().get(0)));

        executorService.shutdown();
    }
}
