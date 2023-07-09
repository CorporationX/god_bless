package Sprint_4_Task22;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Chat {
    User userOne;
    User userTwo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat chat)) return false;
        return Objects.equals(userOne, chat.userOne) && Objects.equals(userTwo, chat.userTwo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userOne, userTwo);
    }
}
