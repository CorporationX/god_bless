package school.faang.m1.future.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private int experience;

    private final ReentrantLock lock = new ReentrantLock();

    public void gainExperience(int experience) {
        lock.lock();
        try {
            this.experience += experience;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Atomically apply XP and level-ups based on cumulative thresholds of 300 XP each.
     */
    public void applyReward(int deltaXp) {
        lock.lock();
        try {
            int before = experience;
            experience = Math.addExact(experience, deltaXp); // overflow-safe
            int gainedLevels = (experience / 300) - (before / 300);
            if (gainedLevels > 0) {
                level = Math.addExact(level, gainedLevels);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        lock.lock();
        try {
            return "Player{name='" + name + "', level=" + level + ", xp=" + experience + "}";
        } finally {
            lock.unlock();
        }
    }
}
