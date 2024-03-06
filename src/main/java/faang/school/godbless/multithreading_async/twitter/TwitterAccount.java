package faang.school.godbless.multithreading_async.twitter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private String username;
    private int followers;

}
