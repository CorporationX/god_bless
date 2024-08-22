package faang.school.godbless.bjs2_23452;

import lombok.Getter;

import java.util.List;

public class CustomThread extends Thread {
    private final String name;
    private final List<Character> characters;
    @Getter
    private int power;

    public CustomThread(List<Character> characters, String name) {
        this.characters = characters;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " is calculating total power of " + characters.size() + " characters");
        power = characters.stream()
                .mapToInt(Character::getPower)
                .sum();
        System.out.println("Thread " + name + " finished calculation. Total power: " + power);
    }
}
