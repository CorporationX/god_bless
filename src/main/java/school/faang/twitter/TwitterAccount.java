package school.faang.twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    @NonNull
    private String name;
    private int followers;
}
