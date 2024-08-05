package Abstract;

    public class Warrior extends Character {
        protected static String name;
        protected static int power;

        public Warrior(String name) {
            super(name);
            this.name = name;
            super.setPower(10);
            this.power = super.getPower();
            super.setAgility(5);
            super.setIntelligent(3);
        }

        public static int getPower() {
            return power;
        }

        public static String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        public Warrior(String name, int power, int agility, int intelligent) {
            super(name, power, agility, intelligent);
        }


        @Override
        public void atack(Character character) {
            System.out.println(Warrior.getName() + " наносит урон " +
                    Character.getName() + " в размере " +
                    Warrior.getPower() + " очков урона");
            Character.setHealth(health - Warrior.getPower());
            System.out.println("игроку " + Character.getName() + " нанесено "
                    + Warrior.getPower() + " урона. Здоровья осталось: "
                    + Character.getHealth());

        }

    }

