package faang.school.godbless.task_1;

public abstract class Creature {
    String name;
    int level;
    int attack;
    int protection; //защита
    int speed;
    int amount;  //количество

    public abstract int getDamage();
}
