package faang.school.godbless.matters_of_heart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chat {
    private User user1;
    private User user2;

    public void removeUserChat() {
        user1.setWantToStartChat(true);
        user2.setWantToStartChat(true);
        user1 = null;
        user2 = null;
    }
}
