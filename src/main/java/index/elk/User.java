package index.elk;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private static int idCount = 1;

    private final int id;
    private final String name;

    public User(@NonNull String name) {
        this.id = idCount++;
        this.name = name;
    }
}
