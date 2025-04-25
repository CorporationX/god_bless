package school.faang.bjs2_72951;

public class Main {

    private static final String[] CHORES = {
            "помыть посуду",
            "подмести пол",
            "приготовить ужин",
            "постирать одежду",
            "покормить фестралов"
    };

    public static void main(String[] args) {
        WeasleyFamily weasleys = new WeasleyFamily(CHORES);
        System.out.println("Семья Уизли начинает выполнять домашние дела:");
        weasleys.doChores();

        try {
            Thread.sleep(5000);
            System.out.println("\nВсе дела выполнены!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
