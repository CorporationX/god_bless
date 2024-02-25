package faang.school.godbless.distributedarmy;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Divisions {
    private int power;


    public boolean isMage() {
        return false;
    }
    public boolean isArcher() {
        return false;
    }
    public boolean isSwordsman() {
        return false;
    }
}
