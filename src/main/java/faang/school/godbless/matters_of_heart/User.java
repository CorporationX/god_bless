package faang.school.godbless.matters_of_heart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private boolean isOnline;
    private boolean wantToStartChat;

    @Override
    public String toString() {
        return name;
    }
}
