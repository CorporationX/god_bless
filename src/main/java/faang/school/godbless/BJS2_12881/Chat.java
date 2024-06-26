package faang.school.godbless.BJS2_12881;

import lombok.Getter;

@Getter
public class Chat {
    private final User firstUser;
    private final User secondUser;
    private final boolean isFull;

    public Chat(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.isFull = true;
    }
}
