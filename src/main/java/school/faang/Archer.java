package school.faang;

class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character hostile) {
        System.out.println(getName() + " стреляет из эльфийского лука в " + hostile.getName() + " с ловкостью " + getAgility());
        hostile.setHealth(hostile.getHealth() - getAgility());
        System.out.println(hostile.getName() + " теряет " + getAgility() + " здоровья и остается с " + hostile.getHealth() + " здоровья");
    }
}
