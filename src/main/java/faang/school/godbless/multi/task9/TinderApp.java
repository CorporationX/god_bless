package faang.school.godbless.multi.task9;

public class TinderApp {
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        for (int i = 0; i < 7; i++) {
            userList.addUser(new User("User" + i));
        }
        System.out.println("-------------------------------------");

        for (User user: userList.getUsers()) {
            chatManager.simulateChat(user);
        }
    }
}
