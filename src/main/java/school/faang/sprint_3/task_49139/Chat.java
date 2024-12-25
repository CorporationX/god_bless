package school.faang.sprint_3.task_49139;

import lombok.Getter;

@Getter
public class Chat {
    private final User firstUser;
    private final User secondUser;

    public Chat(User firstUser, User secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        System.out.println("Chat with "
                + firstUser
                + " and "
                + secondUser
                + " created by "
                + Thread.currentThread().getName());
    }
}
