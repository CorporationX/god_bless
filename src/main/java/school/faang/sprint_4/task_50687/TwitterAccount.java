package school.faang.sprint_4.task_50687;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class TwitterAccount {
    private final String username;
    private int followers;

    public synchronized void addFollower() {
        followers += 1;
    }
}
