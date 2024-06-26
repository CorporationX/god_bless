package faang.school.godbless.CelebrityInTwitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;
}
