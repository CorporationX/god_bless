package school.faang.sprint_4.task_43580;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers;

    public void incrementFollowers() {
        followers++;
    }
}