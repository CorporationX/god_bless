package school.faang.sprint4.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int reward) {
        experience += reward;
    }


//    private ReadWriteLock lock = new ReentrantReadWriteLock();
//
//    public Player(String name, int level, int experience) {
//        this.name = name;
//        this.level = level;
//        this.experience = experience;
//    }
//
//    public int getExperience() {
//        lock.readLock().lock();
//        try {
//            return experience;
//        } finally {
//            lock.readLock().unlock();
//        }
//    }
//
//    public void addExperience(int reward) {
//        lock.writeLock().lock();
//        try {
//            this.experience += reward;
//        } finally {
//            lock.writeLock().unlock();
//        }
//    }
}
