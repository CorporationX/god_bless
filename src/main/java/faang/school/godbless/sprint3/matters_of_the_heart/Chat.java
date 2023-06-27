package faang.school.godbless.sprint3.matters_of_the_heart;


import java.util.ArrayList;
import java.util.List;


public class Chat {
    private final User user;
    private final User target;
    private final List<String> messages = new ArrayList<>();

    public Chat(User user1, User user2) {
        this.user = user1;
        this.target = user2;
    }

    public User getOtherUser(User user) {
        if (user.getName().equals(user.getName())) {
            return target;
        } else {
            return user;
        }
    }

    public boolean getUserInChat(User user){
        return this.user.getName().equals(user.getName());
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public void printMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

}