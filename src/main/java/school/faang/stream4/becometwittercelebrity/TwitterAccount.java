package school.faang.stream4.becometwittercelebrity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers;

}
