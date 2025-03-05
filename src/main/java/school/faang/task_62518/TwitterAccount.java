package school.faang.task_62518;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private final String username;
    private int followers = 0;
}
