package faang.school.godbless.sprint4_multithreading.army;

public class CharacterPower extends Thread{
    private Characters characters;
    public int power;
    public CharacterPower(Characters characters){
        this.characters = characters;
    }
    
}
