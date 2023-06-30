package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
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
