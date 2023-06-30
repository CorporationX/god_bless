package faang.school.godbless.mattersOfTheHeart;

import java.util.List;

public class ChatManager {
    public synchronized void startChat(User user){
        if(user.getIsWantToChat()) {
            List<User> allOthers = UserList.allUsers.stream()
                    .filter(every -> !every.equals(user))
                    .toList();
            if (allOthers.isEmpty()) {
                try {
                    System.out.println(user.getName() + " ожидает свободного собеседника");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            User userReady = allOthers.stream()
                    .filter(User::getIsOnline)
                    .filter(User::getIsWantToChat)
                    .findAny().orElse(null);
            if (userReady == null) {
                try {
                    user.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            Chat chat = new Chat(user, userReady);
            user.setChat(chat);
            user.setIsWantToChat(false);
            userReady.setChat(chat);
            userReady.setIsWantToChat(false);
            System.out.println(user.getName() + " начал чат с " + userReady.getName());
        }
    }

    public synchronized void waitForChat(User user){
        if(user.getChat() != null){
            System.out.println(user.getName() + " пока не имеет чата");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void endChat(User user){
        user.getChat().firstUser.setChat(null);
        user.getChat().secondUser.setChat(null);
        System.out.println(user.getName() + " закончил чат");
        user.setIsWantToChat(true);
        this.notifyAll();

    }

}
