package faang.school.godbless.Sprint4.MattersOfTheHeart;

import java.util.List;

public class UserList {
    private static long id=0;
    static List<User> users = initializationUsers();

    public static void main(String[] args) throws InterruptedException {
        ChatManager chatManager = new ChatManager(users);

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                chatManager.addOnline(users.get(0));
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            chatManager.endChat(users.get(0));
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(8000);
                chatManager.addOnline(users.get(1));
                Thread.sleep(8000);
                chatManager.waitForChat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            chatManager.endChat(users.get(1));
        });
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                chatManager.addOnline(users.get(2));
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            chatManager.endChat(users.get(2));
        });
        Thread thread4 = new Thread(() -> {
            try {
                chatManager.addOnline(users.get(3));
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            chatManager.endChat(users.get(3));
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


    private static List<User> initializationUsers() {
        return List.of(new User("Иван",++id),
                new User("Маша",++id),
                new User("Петр",++id),
                new User("Даша",++id),
                new User("Сергей",++id),
                new User("Катя",++id)
        );
    }
}
