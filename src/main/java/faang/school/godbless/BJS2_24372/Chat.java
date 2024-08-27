package faang.school.godbless.BJS2_24372;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chat {
    private User user;
    private User partner;

    public void chatting() {
        System.out.println(user.getName() + " chats with " + partner.getName());
    }
}
