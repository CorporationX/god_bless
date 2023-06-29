package faang.school.godbless.tinder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class User {

    private int userId;
    private String name;
    private boolean isOnline;
    @Setter
    private List<User> likedUsers = new ArrayList<>();
    private boolean hiddenStatus;
    @Setter
    private int waitingCounter = 0;


    public User(int userId, String name, boolean isOnline, boolean hiddenStatus) {
        this.userId = userId;
        this.name = name;
        this.isOnline = isOnline;
        this.hiddenStatus = hiddenStatus;
    }

    public boolean getIsOnline() {
        if (hiddenStatus) {
            return false;
        } else {
            return isOnline;
        }
    }

    public synchronized void removeFromLiked(User user) {
        likedUsers.remove(user);
    }

    public boolean wantToChatWith(User user) {
        return likedUsers.contains(user);
    }

    public void incrementCounter(){
        waitingCounter++;
    }
}
