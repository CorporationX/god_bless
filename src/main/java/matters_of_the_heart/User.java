package matters_of_the_heart;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private final int id;
    private final String name;
    @Setter
    private boolean isOnline;

    public User(int id, String name, boolean isOnline) {
        this.id = id;
        this.name = name;
        this.isOnline = isOnline;
    }
}
