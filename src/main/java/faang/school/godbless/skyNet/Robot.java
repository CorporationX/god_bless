package faang.school.godbless.skyNet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Robot {
    private final String target;

    public void attack(){
        synchronized (target){
            System.out.println(Thread.currentThread().getName() + " таргет " + getTarget() + " уничтожен");

        }
    }
}
