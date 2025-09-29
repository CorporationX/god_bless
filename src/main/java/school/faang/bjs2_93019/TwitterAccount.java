package school.faang.bjs2_93019;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TwitterAccount {

    private final String name;
    private int followers = 0;
}
