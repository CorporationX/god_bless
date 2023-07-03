package faang.school.godbless.matters_of_the_heart;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class User {
    private String name;
    private boolean isOnline = true;
    private boolean prepareToChat = false;

    public User(String name) {
        this.name = name;
    }

    public synchronized void exit() {
        isOnline = false;
        System.out.println(this.getName() + " exited the app");
    }

    public synchronized void connect() {
        isOnline = true;
    }

    public synchronized void searchChat() {
        prepareToChat = true;
    }

    public synchronized void toDoNotDisturb() {
        prepareToChat = false;
    }
}
