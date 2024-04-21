package faang.school.godbless.army_of_heroes;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Hero {
    private int power;

    public boolean isMage() {return false;}

    public boolean isArcher() {return false;}

    public boolean isSwordsMan() {return false;}
}
