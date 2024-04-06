package faang.school.godbless.core.task_3;

import faang.school.godbless.core.task_3.model.Character;
import faang.school.godbless.core.task_3.model.Warrior;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Воин");
        Character archer = new Warrior("Лучник");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}