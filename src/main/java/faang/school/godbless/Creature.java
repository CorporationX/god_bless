package faang.school.godbless;

public abstract class Creature {
    private String name;
    private int lvl = 1;
    protected int attack;
    protected int armor;
    protected int moveSpeed;
    protected int quantity;

    public String toString(){
        return name + " ";
    }

    public Creature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract int getDamage();

    static class Pikeman extends Creature{
        public Pikeman() {
            super("Pikeman");
            this.attack = 5;
            this.armor = 3;
            this.moveSpeed = 8;
            this.quantity = 10;
        }

        @Override
        public int getDamage() {
            return this.attack;
        }
    }

    static class Griffin extends Creature{
        public Griffin() {
            super("Griffin");
            this.attack = 20;
            this.armor = 15;
            this.moveSpeed = 25;
            this.quantity = 1;
        }

        @Override
        public int getDamage() {
            return this.attack;
        }
    }

    static class Swordman extends Creature{
        public Swordman(){
            super("Swordman");
            this.attack = 10;
            this.armor = 5;
            this.moveSpeed = 6;
            this.quantity = 10;
        }
        @Override
        public int getDamage() {
            return this.attack;
        }
    }

    static class Angel extends Creature{
        public Angel(){
            super("Angel");
            this.attack = 50;
            this.armor = 75;
            this.moveSpeed = 15;
            this.quantity = 1;
        }
        @Override
        public int getDamage() {
            return this.attack;
        }
    }
}
