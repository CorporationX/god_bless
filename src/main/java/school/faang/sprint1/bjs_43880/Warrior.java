package school.faang.sprint1.bjs_43880;

public class Warrior extends Character {
    Warrior(String name) {
        super(name);
        defaultSettings();
    }

    @Override
    public void attack(Character character) {
        String phrase = "%s наносит удар, %s теряет %s здоровья\n";
        System.out.println(String.format(phrase, this.name, character.getName(), this.force));
        character.setHealth(health - force);
    }

    private void defaultSettings() {
        this.force = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }
}
