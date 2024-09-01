package faang.school.godbless.BJS224391;

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

        new Thread(() -> {
            try {
                chatManager.startChat(alice);
                Thread.sleep(5000);
                chatManager.endChat(alice);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                chatManager.startChat(bob);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                chatManager.startChat(charlie);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
