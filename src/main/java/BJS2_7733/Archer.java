package BJS2_7733;

public class Archer extends Character{
        String name;

        public Archer (String name){
            super(name);
            super.power = 3;
            super.skill = 10;
            super.intellect = 5;
        }


        public void attack (Character character) {
          character.hp -= this.skill;
        }
    }




