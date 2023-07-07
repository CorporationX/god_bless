package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task11;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private boolean online;

    private String name;

    private boolean wantToStartChat;

    public User(String name, boolean online, boolean wantToStartChat) {
        this.online = online;
        this.name = name;
        this.wantToStartChat = wantToStartChat;
    }

    @Override
    public String toString() {
        return name;
    }
}
