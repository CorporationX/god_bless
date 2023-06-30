package faang.school.godbless.mattersOfTheHeart;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String name;
    private Boolean isOnline;
    private volatile Boolean isWantToChat;
    private Chat chat;

    public User(String name, Boolean isOnline, Boolean isWantToChat) {
        this.name = name;
        this.isOnline = isOnline;
        this.isWantToChat = isWantToChat;
    }
}
