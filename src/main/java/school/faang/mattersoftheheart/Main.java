package school.faang.mattersoftheheart;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        User alice = new User("Alice", true, true);
        User bob = new User("Bob", true, true);
        User charlie = new User("Charlie", true, true);

        userList.addUser(alice);
        userList.addUser(bob);
        userList.addUser(charlie);

        new Thread(() -> chatManager.startChat(alice)).start();
        new Thread(() -> chatManager.startChat(bob)).start();
        new Thread(() -> chatManager.startChat(charlie)).start();
    }
}

