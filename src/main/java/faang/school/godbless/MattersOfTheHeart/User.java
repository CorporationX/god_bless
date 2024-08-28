package faang.school.godbless.MattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;


@Slf4j
@AllArgsConstructor
@Getter
public class User {
    private int id;
    private final Set<Chat> chats = new HashSet<>();


    public String toString(){
        return "User" + id;
    }
    public void addChat(Chat chat){
        chats.add(chat);
    }

    public void removeChat(Chat chat){
        chats.remove(chat);
    }
}
