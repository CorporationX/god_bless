package school.faang.m1s3.bjs2_37459_tinder;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Chat {
    private String name;
    private User user1;
    private User user2;
    private List<String> chatHistory = new ArrayList<>();

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public void sendMessage(User user, String message) {
        System.out.println(user.getName() + " : " + message);
        chatHistory.add(user.getName() + " : " + message);
    }

    public void clearHistory() {
        chatHistory.clear();
        System.out.println("The history of chat is cleared");
    }


}
