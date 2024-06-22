package faang.school.godbless.multithreading_synchronization.task_7;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private final Status status;

    public User(String name, Status status, boolean showStatus) {
        this.name = name;
        this.status = showStatus ? status : Status.UNKNOWN; // if showStatus is true then status else Status.Unknown
    }

    public User(String name, Status status) {
        this(name, status, true);
    }
}