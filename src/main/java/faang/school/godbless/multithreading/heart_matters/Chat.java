package faang.school.godbless.multithreading.heart_matters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Chat {
    private User user1;
    private User user2;

    public void startChat() {
        System.out.println(user1.getName() + " and " + user2.getName() + " started the chat");
    }
}
