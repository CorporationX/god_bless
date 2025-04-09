package school.faang.abstraction;

public class StartHero extends Character {

    public StartHero(String name) {
        super(name);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("Я не умею биться, надо пройти обучение на Буткемпе");
    }
}