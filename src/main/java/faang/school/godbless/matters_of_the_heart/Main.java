package faang.school.godbless.matters_of_the_heart;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        User user1 = new User("Anton");
        User user2 = new User("Nikita");
        User user3 = new User("John");
        User user4 = new User("Jack");
        User user5 = new User("Jimbo");

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);
        userList.addUser(user5);

        ChatManager chatManager = new ChatManager(userList);

        Thread thread1 = new Thread(() -> {
            chatManager.startChat(user1);
            chatManager.waitForChat(user3);
            chatManager.waitForChat(user4);
            chatManager.endChat(chatManager.getChats().get(0));
            user3.exit();
            chatManager.startChat(user1);
        });

        Thread thread2 = new Thread(() -> {
            user3.searchChat();
            user5.searchChat();
            chatManager.startChat(user4);
            chatManager.endChat(chatManager.getChats().get(0));
            chatManager.startChat(user2);
        });

        thread1.start();
        thread2.start();
    }
}
