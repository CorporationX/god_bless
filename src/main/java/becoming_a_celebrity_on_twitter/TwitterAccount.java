package becoming_a_celebrity_on_twitter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private int followers;
}
