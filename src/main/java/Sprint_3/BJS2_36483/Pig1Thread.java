package Sprint_3.BJS2_36483;

public class Pig1Thread extends PigThread {

    public Pig1Thread() {
        super("Ниф-ниф", "Бумага");
    }

    public void run() {
        System.out.println(getPigName() + " начал строить дом из " + getMaterial());
        try {
            Thread.sleep(1000);
            System.out.println(getPigName() + " построил дом из " + getMaterial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
