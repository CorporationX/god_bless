package bjs2_72194;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(Character character){
        if (character != null){
            characters.add(character);
        } else {
            throw new NullPointerException("character is null");
        }
    }

    public int calculateSquadPower(){
        return characters.stream().mapToInt(Character::getPower).sum();
    }
}
