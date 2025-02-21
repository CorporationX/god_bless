package school.faang.heroesofmightandmagic;

public class Main {
    public static void main(String[] args) {
        Squad archers = createSquad(new int[]{25, 30}, Archer.class);
        Squad mages = createSquad(new int[]{45, 48}, Mage.class);
        Squad swordsmen = createSquad(new int[]{40, 35}, Swordsman.class);

        System.out.println("Мощность отряда лучников: " + archers.calculateSquadPower());
        System.out.println("Мощность отряда магов: " + mages.calculateSquadPower());
        System.out.println("Мощность отряда мечников: " + swordsmen.calculateSquadPower());

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }

    private static <T extends Unit> Squad createSquad(int[] powers, Class<T> unitClass) {
        Squad squad = new Squad();
        try {
            for (int power : powers) {
                T unit = unitClass.getConstructor(int.class).newInstance(power);
                squad.addUnit(unit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return squad;
    }
}