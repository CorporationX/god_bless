package school.faang.mattersoftheheart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chat {
    private User hostUser;
    private User connectedUser;
}
