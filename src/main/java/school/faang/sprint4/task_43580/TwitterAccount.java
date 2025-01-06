package school.faang.sprint4.task_43580;

import lombok.Data;

@Data
public class TwitterAccount {
    private final String username;
    private int numOfFollowers = 0;
}
