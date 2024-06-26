package matters;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private  boolean isOnline;
    private boolean isChatting;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  isOnline == user.isOnline && isChatting == user.isChatting;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isOnline, isChatting);
    }

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }
}
