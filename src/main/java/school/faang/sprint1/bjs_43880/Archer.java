package school.faang.sprint1.bjs_43880;

public class Archer extends Character {
    Archer(String name) {
        super(name);
        defaultSettings();
    }

    @Override
    public void attack(Character character) {
        String phrase = "%s наносит удар, %s теряет %s здоровья\n";
        System.out.println(String.format(phrase, this.name, character.getName(), this.dexterity));
        character.setHealth(health - dexterity);
    }

    private void defaultSettings() {
        this.force = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }
}
