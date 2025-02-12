package school.faang.task_57468;

public class Main {
    public static void main(String[] args) {
        try {
            Droid r2d2 = new Droid("R2D2");
            System.out.println(r2d2.encryptMessage("The xxizzion is complyyte.", 3));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
