package school.faang.Tinder;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int THREAD_POOL_SIZE = 10;

  public static void main(String[] args) {
    UserList userList = new UserList();
    userList.addUser(new User(1, "Alexander", true, false));
    userList.addUser(new User(2, "Sophia", true, false));
    userList.addUser(new User(3, "Ethan", true, false));
    userList.addUser(new User(4, "Isabella", false, false));
    userList.addUser(new User(5, "Liam", true, false));
    userList.addUser(new User(6, "Mia", true, false));
    userList.addUser(new User(7, "Noah", false, false));
    userList.addUser(new User(8, "Ava", true, false));

    List<User> onlineUsers = userList.getOnlineUsers();
    ChatManager chatManager = new ChatManager();

    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    executorService.submit(() -> chatManager.startChat(onlineUsers.get(0)));
    executorService.submit(() -> chatManager.startChat(onlineUsers.get(1)));

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }

    executorService.submit(() -> chatManager.waitForChat(onlineUsers.get(2)));
    executorService.submit(() -> chatManager.waitForChat(onlineUsers.get(3)));
    executorService.submit(() -> chatManager.waitForChat(onlineUsers.get(4)));

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }

    executorService.submit(() -> chatManager.endChat(chatManager.getChats().get(1)));
    executorService.submit(() -> chatManager.startChat(onlineUsers.get(5)));

    executorService.shutdown();

    try {
      if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        System.out.printf("поток %s дождался завершения дугих потоков\n", Thread.currentThread().getName());
      } else {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
