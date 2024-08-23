package faang.school.godbless.tinder;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        for (int i = 1; i <= 5; i++) {
            User user = new User("User" + i);
            userList.addUser(user);
        }

        for (User user: userList.getUsers()) {
            Thread thread = new Thread(() -> {
                try {
                    chatManager.startChat(user);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            });
            thread.start();
        }
    }
}
