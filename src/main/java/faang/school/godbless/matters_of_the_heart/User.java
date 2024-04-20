package faang.school.godbless.matters_of_the_heart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class User {

    private String name;
    private boolean isOnline;
    private String gender;

    public void startChat(ChatManager chatManager){
        chatManager.startChat(this);
    }

    public void leaveChat(ChatManager chatManager){
        chatManager.endChat(this);
    }

}
