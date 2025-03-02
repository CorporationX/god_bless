package school.faang.task_62511;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private static final int DEFAULT_NUMBER_FOLLOWERS = 0;

    private final String username;

    private int followers = DEFAULT_NUMBER_FOLLOWERS;
}
