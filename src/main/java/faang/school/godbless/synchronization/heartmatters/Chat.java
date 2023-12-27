package faang.school.godbless.synchronization.heartmatters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Chat {

    private final User firstUser;
    private final User secondUser;

    public Chat(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        firstUser.setAvailable(false);
        secondUser.setAvailable(false);
    }

}
