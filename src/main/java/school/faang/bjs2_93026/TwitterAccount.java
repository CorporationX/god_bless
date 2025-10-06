package school.faang.bjs2_93026;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class TwitterAccount {

    private final String username;
    private AtomicInteger followers;

}
