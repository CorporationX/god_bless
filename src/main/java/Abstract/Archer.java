package Abstract;
    public class Archer extends Character {
        protected static String name;
        protected static int power;

        public Archer(String name) {
            super(name);
            this.name = name;
            super.setPower(3);
            this.power = super.getPower();
            super.setAgility(10);
            super.setIntelligent(5);
        }

        public static String getName() {
            return name;
        }

        public static int getPower() {
            return power;
        }

        @Override
        public void setName(String name) {
            Archer.name = name;
        }

        public Archer(String name, int power, int agility, int intelligent) {
            super(name, power, agility, intelligent);

        }

        @Override
        public void atack(Character character) {
            System.out.println(Archer.getName() + " наносит урон " +
                    Character.getName() + " в размере " +
                    Archer.getPower() + " очков урона");
            Character.setHealth(health - Archer.getPower());
            System.out.println("игроку " + Character.getName() + " нанесено "
                    + Archer.getPower() + " урона. Здоровья осталось: "
                    + Character.getHealth());
        }
    }

