package faang.school.godbless.alexbulgakoff.multithreading.synchronization.mattersoftheheart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"online", "consentToChat"})
@ToString
public class User {
    private Long id;
    private String name;
    private boolean online;
    private boolean consentToChat;

    public User(Long id, String name, boolean online) {
        this.id = id;
        this.name = name;
        this.online = online;
        consentToChat = false;
    }
}
