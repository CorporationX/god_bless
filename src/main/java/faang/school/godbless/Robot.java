package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot {
    private String target;

    public synchronized void attack(){
        System.out.println("Attack the target: " + target);
    }
}
