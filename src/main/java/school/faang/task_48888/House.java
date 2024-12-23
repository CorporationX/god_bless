package school.faang.task_48888;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@ToString
public class House {
    private final String houseName;
    private final List<UserRole> userRoles;
    private int possiblePosition;
    private final ReentrantLock lock = new ReentrantLock();

    public House(String houseName, List<UserRole> userRoles) {
        this.houseName = houseName;
        this.userRoles = new ArrayList<>(userRoles);
        possiblePosition = userRoles.size();
    }

    public void addRole(UserRole role) {
        lock.lock();
        try {
            this.possiblePosition--;
            userRoles.remove(role);
        } finally {
            lock.unlock();
        }
    }

    public void removeRole(UserRole role) {
        lock.lock();
        try {
            possiblePosition++;
            userRoles.add(role);
        } finally {
            lock.unlock();
        }
    }
}
