package main.java.faang.school.godbless.abstraction;
    class Archer extends Character {
        public Archer(String name) {
            super(name, 3, 10, 5);
        }

        @Override
        public void attack(Character character) {
            character.health -= this.agility;
            System.out.println("У лучника: "+ character.health);
        }
    }

