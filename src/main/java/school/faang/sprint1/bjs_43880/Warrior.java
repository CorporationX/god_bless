package school.faang.sprint1.bjs_43880;

public class Warrior extends Character {
    Warrior(String name) {
        super(name);
        defaultSettings();
    }

    Warrior(int force, int dexterity, int intelligence) {
        super(force, dexterity, intelligence);
        setName();
    }

    @Override
    public void attack(Character character) {
        System.out.println(String.format("%s наносит удар, %s теряет %s здоровья\n", this.name, character.name, this.force));
        character.health -= force;
    }

    private void defaultSettings() {
        this.force = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }
}
