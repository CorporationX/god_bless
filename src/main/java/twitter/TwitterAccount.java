package twitter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private String username ;
    private int followers;
}
