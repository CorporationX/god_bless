package faang.school.godbless.Sprint4.MattersOfTheHeart;

import lombok.Getter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
public class ChatManager {
    private static Set<Chat> chats = new HashSet<>();
    private static List<User> onlinePeople = new LinkedList<>();
    private static List<User> users;

    public void addOnline(User user) throws InterruptedException {
        System.out.println("Chat started for " + user.getName());
        user.isOnlineOn();
        startChat(user);
    }

    public synchronized void startChat(User you) throws InterruptedException {
        onlinePeople = users.stream()
                .filter(user -> (user.isOnline())).toList();

        if (onlinePeople.size() == 1) {
            System.out.println("No one is online for " + you.getName());
            return;
        }

        onlinePeople.stream().filter(user -> user != you).forEach(user -> addNewChar(user, you));
        System.out.println(" chats for " + you.getName());
        chats.stream().forEach(chat -> System.out.println(chat.getName()));

        System.out.println("People - online: " + onlinePeople);
    }

    public synchronized void endChat(User user) {
        System.out.println("Chat ended for " + user.getName());

        List<Chat> chatForDelete = chats.stream().
                filter(chat -> chat.getName().contains(user.getName())).toList();
        chatForDelete.forEach(chat -> chats.remove(chat));

        user.isOnlineOff();
        notifyAll();
    }

    public synchronized void waitForChat() throws InterruptedException {
        if (chats.isEmpty()) {
            System.out.println("Any chat isn't exist");
            wait();
        }
    }

    public void addNewChar(User user1, User user2) {
        if (user1.getId() > user2.getId()) {
            chats.add(new Chat(user2, user1, user2.getName() + " - " + user1.getName()));
        } else {
            chats.add(new Chat(user1, user2, user1.getName() + " - " + user2.getName()));
        }
    }

    ChatManager(List<User> users) {
        this.users = users;
    }
}
