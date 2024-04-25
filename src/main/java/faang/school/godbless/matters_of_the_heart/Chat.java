package faang.school.godbless.matters_of_the_heart;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Chat {

    private final List<User> usersInChat = new ArrayList<>(2);

    public void addUserToChat(User user) {
        if(usersInChat.size() == 2){
            System.out.println("Couldn't add a participant");
        }else{
            usersInChat.add(user);
            System.out.println("Could add a participant: " + user.getName());
        }
    }

    public void removeFromChat(User user){
        usersInChat.remove(user);
    }

    public boolean isParticipating(User user){
        return usersInChat.contains(user);
    }
}
