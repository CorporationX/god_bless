package faang.school.godbless.Multithreading.ParallelismAndThread.task05_heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Unit {
    private int power;
    public boolean isMage(){
        return false;
    }
    public boolean isArcher(){
        return false;
    }
    public boolean isSwordsman(){
        return false;
    }
}
