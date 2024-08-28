package faang.school.godbless.BJS2_24418;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chat {
    private User user1;
    private User user2;

    public void startTalk() {
        System.out.println(user1.getName() + " talking with " + user2.getName());
    }
}
