package faang.school.godbless.BJS2_24444;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private String name;
    private boolean isOffline;
    private boolean isWantTalk;
}
