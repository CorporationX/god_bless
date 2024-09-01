package matters_of_the_heart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Chat {
    private final int id;
    private final User firstUser;
    private final User secondUser;
}
