package faang.school.godbless.kxnvg.tinder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TinderRunner {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            User user = new User("user" + i);
            user.setOnline(true);
            UserList.addUser(user);
        }


        ChatManager manager = new ChatManager();

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 20; i++) {
            final int a = i;
            service.execute(() -> manager.startChat(UserList.getAllUsers().get(a)));
            if (a % 4 == 0) {
                service.execute(() -> manager.endChat(UserList.getAllUsers().get(a)));
            }
            if (a % 9 == 0) {
                service.execute(() -> manager.waitForChat(UserList.getAllUsers().get(a)));
            }
        }
        service.shutdown();
    }
}
