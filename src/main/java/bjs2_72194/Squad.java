package bjs2_72194;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(Character character){
        characters.add(character);
    }

    public int calculateSquadPower(){
        return characters.stream().mapToInt(Character::getPower).sum();
    }
}
