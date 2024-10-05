package dima.evseenko.heroes.entity;

public interface Attacking {
    void attack(Creature creature);
    void takeDamage(int damage);
}
