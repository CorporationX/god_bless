package faang.school.godbless.group.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NonNull
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

}
