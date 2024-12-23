package heroofmightandmagic;

public class Main {
    public static void main(String[] args) {
        try {
            Army army = new Army();
            army.addUnit(new Archer(25));
            army.addUnit(new Swordsman(40));
            army.addUnit(new Mage(50));
            army.addUnit(new Mage(20));

            int totalPower = army.calculateTotalPower();
            System.out.println("Общая сила армии: " + totalPower);

        } catch (IllegalArgumentException e) {

            System.err.println("Ошибка: Неверный аргумент. " + e.getMessage());

        } catch (InterruptedException e) {

            System.err.println("Ошибка: Поток был прерван во время расчета силы армии.");
            Thread.currentThread().interrupt();

        } catch (Exception e) {

            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
