package faang.school.godbless.tinder;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static UserList getUserList() {
    User max = new User("Max");
    User dima = new User("Dima");
    User petr = new User("Petr");
    User alex = new User("Alex");
    User maria = new User("Maria");
    User georg = new User("Georg");
    User vova = new User("Vova");
    User katya = new User("katya");
    User olya = new User("olya");


    UserList userList = new UserList();
    userList.addUser(max);
    userList.addUser(dima);
    userList.addUser(petr);
    userList.addUser(alex);
    userList.addUser(maria);
    userList.addUser(georg);
    userList.addUser(vova);
    userList.addUser(katya);
    userList.addUser(olya);

    return userList;
  }
  public static void main(String[] args) {
    UserList userList = getUserList();
    ChatManager chatManager = new ChatManager(userList);

    ExecutorService executor = Executors.newFixedThreadPool(4);
    List<User> users = userList.getUsers();

    int i = 0;

    while (i < 3) {
      User currentUser = users.get(i);
      if (!currentUser.isWaitingForChat()) continue;

      executor.execute(() -> chatManager.startChat(currentUser));
      i++;
    }



    // executor.execute(() -> chatManager.endChat(chatManager.getChatList().get(0)));

    executor.shutdown();

    try {
      executor.awaitTermination(20, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("done");
  }
}
