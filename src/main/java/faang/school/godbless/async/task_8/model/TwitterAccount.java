package faang.school.godbless.async.task_8.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwitterAccount {
    private final String username;
    private int followers;
}