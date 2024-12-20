package derschrank.sprint03.task03.bjstwo_48427;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        System.out.println(" -----> Add task #1");
        for (int i = 0; i < 50; i++) {
            weasleyFamily.addChore(new Chore("Do something: " + i));
        }

        System.out.println(" -----> Start do Chores");
        weasleyFamily.start();

        System.out.println(" -----> Add task #2");
        for (int i = 0; i < 50; i++) {
            weasleyFamily.addChore(new Chore("Do something TWO: " + i));
        }


        try {
            weasleyFamily.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" -----> Main was ended");
        System.out.println(" We have still tasks: " + weasleyFamily.getSize());
    }
}
