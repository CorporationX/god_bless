package faang.school.godbless.sprint3.matters_of_the_heart;

public class Main {
    public static void main(String[] args) {

        UserList userList = new UserList();

        User user1 = new User("Pavel", true);
        User user2 = new User("Vlad", true);
        User user3 = new User("Anton", true);
        User user4 = new User("Alex", true);

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);

        ChatManager chatManager = new ChatManager(userList);

        Thread thread1 = new Thread(() -> {
            chatManager.startChat(user1);
            Chat chat = chatManager.waitForChat(user1);
            System.out.println(user1.getName() + " got a chat with " + chat.getOtherUser(user1).getName());
            chat.addMessage("Hello from chat 1");
            chat.printMessages();
        });

        Thread thread2 = new Thread(() -> {
            Chat chat = chatManager.waitForChat(user2);
        });

        Thread thread3 = new Thread(() -> {
            Chat chat = chatManager.waitForChat(user3);
        });

        Thread thread4 = new Thread(() -> {
            chatManager.startChat(user4);
            Chat chat = chatManager.waitForChat(user4);
            System.out.println(user4.getName() + " got a chat with " + chat.getOtherUser(user4).getName());
            chat.addMessage("Hello from chat 2");
            chat.printMessages();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}

