package faang.school.godbless.BJS2_24364;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        User userOne = new User("One", true);
        User userTwo = new User("Two", true);
        User userThree = new User("Three", true);

        UserList userList = new UserList();
        userList.addUser(userOne);
        userList.addUser(userTwo);
        userList.addUser(userThree);

        ChatManager manager = new ChatManager(userList);

        Runnable userOneUseTinder = () -> {
            manager.startChat(userOne);
            sleepWithTryCatchBlock(5000);
            manager.endChat(userOne);
            userOne.setOnline(false);
        };

        Runnable userTwoUseTinder = () -> {
            sleepWithTryCatchBlock(2000);
            manager.startChat(userTwo);
        };

        Runnable userThreeUseTinder = () -> {
            sleepWithTryCatchBlock(7000);
            manager.startChat(userThree);
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(userOneUseTinder);
        executor.execute(userTwoUseTinder);
        executor.execute(userThreeUseTinder);
        executor.shutdown();
    }


    private static void sleepWithTryCatchBlock(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleep error");
        }
    }
}
