package school.faang.sprint_2.task_46215;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2", 3);
        Droid c3po = new Droid("C3PO", 5);

        r2d2.sendMessage(c3po, "Давным-давно в далёкой-далёкой галактике");
        c3po.receiveMessage(r2d2);
        c3po.sendMessage(r2d2, "Да пребудет с тобой сила!");
        r2d2.receiveMessage(c3po);

        Droid bb8 = new Droid("BB-8", 5);
        c3po.receiveMessage(bb8);
    }
}
