package school.faang.bjs2_81766_matters_of_heart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private boolean isOnline;
    private boolean isLookingForChat;
}
