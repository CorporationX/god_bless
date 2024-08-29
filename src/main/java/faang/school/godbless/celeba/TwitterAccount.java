package faang.school.godbless.celeba;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class TwitterAccount {
    @Setter
    private String username;
    private AtomicInteger followers;

    public Integer addFollowers(int followers) {
        return this.followers.addAndGet(followers);
    }
}
