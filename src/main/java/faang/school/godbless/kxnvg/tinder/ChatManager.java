package faang.school.godbless.kxnvg.tinder;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;

public class ChatManager {


    @SneakyThrows
    public synchronized void startChat(User user) {
        List<User> availableUsers = getAvailableUsers(user);

        if (availableUsers.isEmpty()) {
            waitForChat(user);
        }
        availableUsers = getAvailableUsers(user);
        User otherUser = availableUsers.get(new Random().nextInt(availableUsers.size()));

        Chat chat = new Chat(user, otherUser);
        chat.startOfChating();
    }

    public synchronized boolean endChat(User user) {
        if (user.getActualChat() == null) {
            System.out.println(user.getName() + " не имеет рабочих чатов на данный момент");
            return false;
        }

        Chat chat = user.getActualChat();
        chat.finishChating();
        notifyAll();
        return true;
    }

    @SneakyThrows
    public synchronized void waitForChat(User user) {
        if (user.getActualChat() == null) {
            System.out.println(user.getName() + " ожидает свободного собеседника...");
            wait();
        }
    }

    private List<User> getAvailableUsers(User user) {
        return UserList.getOnlineUsers().stream()
                .filter(x -> !x.equals(user))
                .filter(x -> x.getActualChat() == null)
                .toList();
    }
}
