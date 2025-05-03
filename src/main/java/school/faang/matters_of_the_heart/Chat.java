package school.faang.matters_of_the_heart;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Chat {
    private User user1;
    private User user2;
    private List<String> messages = new ArrayList<>();

    public Chat(User user1) {
        this.user1 = user1;
    }

    public void addMessage(String message, User user) {
        if (user2 == null) {
            throw new IllegalArgumentException("второй юзер еще не найден");
        } else {
            if ((user.equals(user1) || user.equals(user2))) {
                messages.add("Сообщение от " + user.getName() + ": " + message);
            } else {
                throw new IllegalArgumentException("В этом чате таких нет");
            }
        }
    }
}
