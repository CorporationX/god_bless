package faang.school.godbless.multithreading.mattersoftheheart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private String name;
    private boolean isOffline;
    private boolean isWantTalk;

}
