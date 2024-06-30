package faang.school.godbless.sprint_3.multithreading_synchronization.task_7_tinder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
    private final String name;
    private boolean online;
    private Status status;

    public User(String name) {
        this.name = name;
        this.online = false;
        this.status = Status.OFFLINE;
    }

    public synchronized void online() {
        if (!this.online) {
            this.online = true;
        }
    }

    public synchronized void offline() {
        if (this.online) {
            this.online = false;
            this.status = Status.OFFLINE;
        }
    }

    public synchronized void setStatus(Status status) {
        switch (status) {
            case ONLINE -> System.out.printf("пользователь %s online\n", name);
            case LOOKING_FOR_CHAT -> System.out.printf("пользователь %s хочет поболтать\n", name);
            case CHATTING -> System.out.printf("пользователь %s в чате\n", name);
            default -> System.out.printf("пользователь %s offline\n", name);
        }

        this.status = status;
    }

    // Присвоение случайного статуса после завершенного чата
    public synchronized void setRandomStatus() {
        int chance = (int) (Math.random() * 10 / 3);

        Status randomStatus = switch (chance) {
            case 1 -> Status.ONLINE;
            case 2 -> Status.LOOKING_FOR_CHAT;
            default -> Status.OFFLINE;
        };

        setStatus(randomStatus);
    }

}
