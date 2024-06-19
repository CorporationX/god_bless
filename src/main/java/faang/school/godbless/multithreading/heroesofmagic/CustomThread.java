package faang.school.godbless.multithreading.heroesofmagic;

public class CustomThread extends Thread {

    private int power;
    private Character character;

    public CustomThread(Character character) {
        this.character = character;
    }
    public int getPower() {
        return power;
    }

    @Override
    public void run(){
        power = character.getPower();
    }
}
