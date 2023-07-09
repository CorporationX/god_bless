package faang.school.godbless.matters_of_the_heart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chat {
    private User user1;
    private User user2;

    public void chatting() {
        System.out.println(user1.getName() + " start chat with " + user2.getName());
    }
}
