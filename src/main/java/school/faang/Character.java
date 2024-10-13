package school.faang;

public abstract class Character {
    protected String name;
    protected int levelOfPower;
    protected int levelOfAgility;
    protected int levelOfIntellect;
    protected int levelOfHealth;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int levelOfPower, int levelOfAgility, int levelOfIntellect,
                     int levelOfHealth) {
        this.name = name;
        this.levelOfPower = levelOfPower;
        this.levelOfAgility = levelOfAgility;
        this.levelOfIntellect = levelOfIntellect;
        this.levelOfHealth = levelOfHealth;
    }

    public abstract void attack(Character character);

    public static class Warrior extends Character {

        public Warrior(String name) {
            super(name);
            levelOfPower = 10;
            levelOfAgility = 5;
            levelOfIntellect = 3;
            levelOfHealth = 100;
        }

        public Warrior(String name, int levelOfPower, int levelOfAgility, int levelOfIntellect,
                       int levelOfHealth) {
            super(name, 10, 5, 3, 100);
        }

        @Override
        public void attack(Character enemy) {
            if (enemy instanceof Warrior) {
                Warrior enemyWarrior = (Warrior) enemy;
                if (enemyWarrior.getLevelOfHealth() == 0) {
                    System.out.println("Enemy is dead");
                }
                enemyWarrior.setLevelOfHealth(enemyWarrior.getLevelOfHealth() -
                        this.getLevelOfPower());
            }
            if (enemy instanceof Archer) {
                Archer enemyArcher = (Archer) enemy;
                if (enemyArcher.getLevelOfHealth() == 0) {
                    System.out.println("Enemy is dead");
                }
                enemyArcher.setLevelOfHealth(enemyArcher.getLevelOfHealth() -
                        this.getLevelOfPower());
            }
        }

        public String getName() {
            return this.name;
        }

        public int getLevelOfPower() {
            return this.levelOfPower;
        }

        public int getLevelOfAgility() {
            return this.levelOfAgility;
        }

        public int getLevelOfIntellect() {
            return this.levelOfIntellect;
        }

        public int getLevelOfHealth() {
            return this.levelOfHealth;
        }

        public void setLevelOfHealth(int health) {
            this.levelOfHealth = health;
        }

    }


    public static class Archer extends Character {

        public Archer(String name) {
            super(name);
            levelOfPower = 3;
            levelOfAgility = 10;
            levelOfIntellect = 5;
            levelOfHealth = 100;
        }

        public Archer(String name, int levelOfPower, int levelOfAgility, int levelOfIntellect,
                      int levelOfHealth) {
            super(name, 3, 10, 5, 100);
        }

        @Override
        public void attack(Character enemy) {
            if (enemy instanceof Warrior) {
                Warrior enemyWarrior = (Warrior) enemy;
                enemyWarrior.setLevelOfHealth(enemyWarrior.getLevelOfHealth() -
                        this.levelOfAgility);
            }
            if (enemy instanceof Archer) {
                Archer enemyArcher = (Archer) enemy;
                enemyArcher.setLevelOfHealth(enemyArcher.getLevelOfHealth() -
                        this.levelOfAgility);
            }
        }

        public String getName() {
            return this.name;
        }

        public int getLevelOfPower() {
            return this.levelOfPower;
        }

        public int getLevelOfAgility() {
            return this.levelOfAgility;
        }

        public int getLevelOfIntellect() {
            return this.levelOfIntellect;
        }

        public int getLevelOfHealth() {
            return this.levelOfHealth;
        }

        public void setLevelOfHealth(int health) {
            this.levelOfHealth = health;
        }
    }

    public static void main(String[] args) {
        Warrior character = new Warrior("Oleg");
        Archer character1 = new Archer("Ant");
        character1.attack(character);
        character1.attack(character);
        character1.attack(character);
        System.out.println(character.getLevelOfHealth());
    }
}

