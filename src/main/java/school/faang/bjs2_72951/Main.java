package school.faang.bjs2_72951;

public class Main {

    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "постирать одежду",
                "покормить фестралов"
        };

        WeasleyFamily weasleys = new WeasleyFamily(chores);
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
