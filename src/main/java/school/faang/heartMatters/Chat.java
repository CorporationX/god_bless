package school.faang.heartMatters;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@ToString
public class Chat {
    private static final Random random = new Random();
    private final List<String> chatHistory = new ArrayList<>();
    private final User user1;
    private final User user2;

    public void addHistory(String content) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        chatHistory.add("[" + time + "] " + content);
    }

    public synchronized void sendMessage(User sender, String message) {
        addHistory(sender.getName() + ": " + message);
        User receiver = getOtherUser(sender);
        receiveMessage(receiver, message);
    }

    public synchronized void receiveMessage(User receiver, String message) {
        System.out.println(receiver.getName() + " received message: " + message);
    }

    public User getOtherUser(User user) {
        return user.equals(user1) ? user2 : user1;
    }

    public static String generateRandomMessage() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < random.nextInt(1, alphabet.length()); i++) {
            builder.append(alphabet.charAt(random.nextInt(0, alphabet.length())));
        }
        return builder.toString();
    }

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}
