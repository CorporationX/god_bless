package faang.school.godbless.multithreading.matters_of_the_heart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private String name;

    private boolean isOnline;

    private boolean isCommunication;
}
