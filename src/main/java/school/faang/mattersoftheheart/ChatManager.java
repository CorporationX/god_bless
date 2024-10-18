package school.faang.mattersoftheheart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatManager {
    private UserList users;

    public synchronized Chat startChat(User firstUser){
        if (!firstUser.isLookingForChat()) {
            System.out.println(firstUser.getName() + " уже общается");
            return null;
        }
        User secondUser = waitForChat(firstUser);
        while (secondUser == null) {
            System.out.println(firstUser.getName() + " ждет собеседника");

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            secondUser = waitForChat(firstUser);
        }

        Chat chat = new Chat(firstUser, secondUser);
        firstUser.setLookingForChat(false);
        secondUser.setLookingForChat(false);
        System.out.println("Начат чат между " + firstUser.getName() + " и " + secondUser.getName());
        return chat;
    }

    public synchronized User waitForChat(User firstUser) {
        return users.getOnlineUsers().stream()
                    .filter(user -> !user.equals(firstUser))
                    .findAny()
                    .orElse(null);
    }

    public synchronized void endChat(Chat chat) {
        System.out.println("Окончен чат между " + chat.getFirstUser().getName() + " и " + chat.getSecondUser().getName());
        chat.getFirstUser().setLookingForChat(true);
        chat.getSecondUser().setLookingForChat(true);
        notify();
    }
}