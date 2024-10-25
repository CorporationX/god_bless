package Sprint_3.BJS2_36483;

public class Pig2Thread extends PigThread {

    public Pig2Thread() {
        super("Наф-наф", "Солома");
    }

    public void run() {
        System.out.println(getPigName() + " начал строить дом из " + getMaterial());
        try {
            Thread.sleep(1200);
            System.out.println(getPigName() + " построил дом из " + getMaterial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
