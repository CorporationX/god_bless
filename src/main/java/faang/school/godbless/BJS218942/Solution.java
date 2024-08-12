package faang.school.godbless.BJS218942;

public class Solution {
    public static void main(String[] args) {
        Character warrior = new Warrior("Knight");
        Character archer = new Archer("Elf");

        warrior.attack(archer);
        System.out.println(archer);

        archer.attack(warrior);
        System.out.println(warrior);
    }
}
