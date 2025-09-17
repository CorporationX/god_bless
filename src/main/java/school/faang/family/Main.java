package school.faang.family;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily family = new WeasleyFamily();

        family.addChore("приготовить ужин");
        family.addChore("помыть окна");
        family.addChore("полить растения");

        family.doChores();
    }
}
