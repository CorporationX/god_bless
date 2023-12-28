package faang.school.godbless.tinder;

import lombok.Data;

@Data
public class Chat {
    private User firstUser;
    private User secondUser;
    private boolean isEmpty = true;

    public Chat(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }
}
