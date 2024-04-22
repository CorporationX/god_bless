package faang.school.godbless.bjs2_5684;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private String name;
    private boolean isOnline;

    public void startChat(ChatManager manager) {
        manager.startChat(this);
    }

    public void leaveChat(ChatManager manager) {
        manager.endChat(this);
    }
}
