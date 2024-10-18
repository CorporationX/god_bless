package school.faangSprint3.t11;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        User dasha = new User("Dasha");
        User masha = new User("Masha");
        User sasha = new User("Sasha");

        userList.addUser(dasha);
        userList.addUser(masha);
        userList.addUser(sasha);

        Thread dashaThread = new Thread(() -> {
            try {
                Chat chat = chatManager.startChat(dasha);
                chat.sendMessage(dasha, "Привет!");
                Thread.sleep(1000);
                chatManager.endChat(dasha);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread mashaThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                Chat chat = chatManager.startChat(masha);
                chat.sendMessage(masha, "Привет!");
                Thread.sleep(2000);
                chatManager.endChat(masha);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread sashaThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                Chat chat = chatManager.startChat(sasha);
                chat.sendMessage(sasha, "Всем привет!");
                Thread.sleep(2000);
                chatManager.endChat(sasha);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        dashaThread.start();
        mashaThread.start();
        sashaThread.start();
    }
}