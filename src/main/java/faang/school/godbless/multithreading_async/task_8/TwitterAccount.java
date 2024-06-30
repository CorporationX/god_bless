package faang.school.godbless.multithreading_async.task_8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username) {
        this.username = username;
        followers = 0;
    }
}
