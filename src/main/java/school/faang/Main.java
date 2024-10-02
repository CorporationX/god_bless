package school.faang;

import lombok.Data;

public class Main {
    @Data
    public abstract class Character {
        private String name;
        private Integer power;
        private Integer agility;
        private Integer intellect;
        private Integer health = 100;

        public Character(String name) {
            this.name = name;
        }

        public Character(String name, Integer power, Integer agility, Integer intellect) {
            this.name = name;
            this.power = power;
            this.agility = agility;
            this.intellect = intellect;
        }

        public void takeDamage(Integer damage) {
            this.health -= damage;
        }

        abstract void attack(Character character);
    }

    public class Warrior extends Character {

        public Warrior(String name) {
            super(name, 10, 5, 3);
        }

        @Override
        public void attack(Character character) {
            character.takeDamage(this.getPower());
        }
    }

    public class Archer extends Character {

        public Archer(String name) {
            super(name, 3, 10, 5);
        }

        @Override
        public void attack(Character character) {
            character.takeDamage(this.getAgility());
        }
    }
}