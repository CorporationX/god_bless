package school.faang.task_50751;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@AllArgsConstructor
@Getter
@Setter
public class TwitterAccount {
    private String username;
    private AtomicInteger followers;
    private List<User> users = new ArrayList<>();
}
