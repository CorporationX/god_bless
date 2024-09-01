package becoming_celebrity_on_twitter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers = 0;
}
