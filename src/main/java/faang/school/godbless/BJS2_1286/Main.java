package faang.school.godbless.BJS2_1286;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        User eda = new User("Eda", true);
        User umar = new User("Umar", true);
        User vlad = new User("Vlad", true);
        User user4 = new User("Putin", true);
        User user5 = new User("Kadyrov", true);
        userList.addUser(eda);
        userList.addUser(umar);
        userList.addUser(vlad);
        userList.addUser(user4);
        userList.addUser(user5);

        userList.follow(eda, umar);
        userList.follow(eda, vlad);
        userList.follow(eda, user4);
        userList.follow(umar, eda);
        userList.follow(vlad, eda);

        System.out.println(userList.getMutualFollowUserPairs());
        System.out.println(userList.followsToEachOther(umar, eda));

        ChatManager chatManager = new ChatManager(userList);

        Thread thread1 = new Thread(() -> chatManager.startChat(eda));
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread thread3 = new Thread(() -> chatManager.startChat(vlad));
        thread3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread thread2 = new Thread(() -> chatManager.startChat(umar));
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread thread5 = new Thread(() -> chatManager.startChat(eda));
        thread5.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread thread4 = new Thread(() -> chatManager.endChat(eda));
        thread4.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread thread6 = new Thread(() -> chatManager.startChat(eda));
        thread6.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
