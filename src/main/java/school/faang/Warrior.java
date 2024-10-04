package school.faang;

class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character hostile) {
        System.out.println(getName() + " обрушивает свою мощь на " + hostile.getName() + " с силой " + getStrength());
        hostile.setHealth(hostile.getHealth() - getStrength());
        System.out.println(hostile.getName() + " теряет " + getStrength() + " здоровья и остается с " + hostile.getHealth() + " здоровья");
    }
}
