package school.faang.twitter_celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TwitterAccount {
    private final String name;
    private int followers;

}
