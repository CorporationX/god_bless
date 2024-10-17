package school.faang.weasley.family;

public class Main {
    public static void main(String[] args) {
        Chore cleaning = new Chore("Уборка");
        Chore washingDishes = new Chore("Мытье посуды");
        Chore digUpPotatoes = new Chore("Вскопать картошку");
        Chore fixTheCar = new Chore("Починить машину");
        Chore removeLeaves = new Chore("Убрать листья");

        WeasleyFamily family = new WeasleyFamily();
        family.addChore(cleaning);
        family.addChore(washingDishes);
        family.addChore(digUpPotatoes);
        family.addChore(fixTheCar);
        family.addChore(removeLeaves);

        family.executeRoutine();
    }
}
