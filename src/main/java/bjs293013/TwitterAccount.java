package bjs293013;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers;
}
