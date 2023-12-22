package faang.school.godbless.synchronization.heartmatters;

public class MattersOfTheHeartApp {

    public static void main(String[] args) throws InterruptedException {
        UserList userList = new UserList();
        userList.addUser(new User(1, "user1", false));
        userList.addUser(new User(2, "user2", false));
        userList.addUser(new User(3, "user3", false));
        userList.addUser(new User(4, "user4", true));
        userList.addUser(new User(5, "user5", true));
        userList.addUser(new User(6, "user6", false));

        ChatManager chatManager = new ChatManager(userList);


        for (User user : userList.getUsers()) {
            new Thread(() -> {
                try {
                    Chat chat = chatManager.startChat(user);
                    chatManager.waitForChat(chat);
                    chatManager.endChat(chat);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupted");
                }
            }).start();
        }
    }

}
