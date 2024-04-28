package faang.school.godbless.mattersOfTheheart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User vanya = new User("Vanya", true, UserChatStatus.AVAILABLE);
        User vasya = new User("Vasya", true, UserChatStatus.AVAILABLE);
        User vova = new User("Vova", true, UserChatStatus.AVAILABLE);
        User viktor = new User("Viktor", true, UserChatStatus.AVAILABLE);
        User violeta = new User("Violeta", true, UserChatStatus.AVAILABLE);

        ChatManager chatManager = new ChatManager();
        chatManager.addUser(vanya);
        chatManager.addUser(vasya);
        chatManager.addUser(vova);
        chatManager.addUser(viktor);
        chatManager.addUser(violeta);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(() -> chatManager.waitForChat(vanya));
        executor.submit(() -> chatManager.startChat(vova));
        executor.submit(() -> chatManager.startChat(vasya));
        executor.submit(() -> chatManager.startChat(vova));
        executor.submit(() -> chatManager.startChat(viktor));
        executor.submit(() -> chatManager.startChat(violeta));
        executor.submit(() -> chatManager.endChat(vanya));
        executor.shutdown();
        Thread.sleep(5000);
        System.out.println(chatManager.getChats());


    }
}
