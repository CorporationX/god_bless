package faang.school.godbless.async.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int exp;
    
    public synchronized void addExp(int additionalExp) {
        exp += additionalExp;
    }
}
