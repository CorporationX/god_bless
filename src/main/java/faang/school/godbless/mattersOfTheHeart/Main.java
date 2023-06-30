package faang.school.godbless.mattersOfTheHeart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            UserList.allUsers.add(new User("user №" + i, true, true));
        }
        ChatManager chatManager = new ChatManager();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 40; i++) {
            final int a;
            if(i >= 30){
                a = i - 30;
            } else {
                a = i;
            }
            executor.submit(() -> {
                chatManager.startChat(UserList.allUsers.get(a));
                chatManager.waitForChat(UserList.allUsers.get(39 - a));
                chatManager.endChat(UserList.allUsers.get(a));
            });
        }
        executor.shutdown();

        try{
            if(executor.awaitTermination(3, TimeUnit.SECONDS)){
                System.out.println("Программа завершена");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
