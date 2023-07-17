package faang.school.godbless.multithreading.matters_heart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chat {
    private User user1;
    private User user2;

    public void close(){
        user1.setWantsToChat(false);
        user2.setWantsToChat(false);
    }
}
