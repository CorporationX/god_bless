package Sprint_3.BJS2_36483;

public class Pig3Thread extends PigThread {

    public Pig3Thread() {
        super("Нуф-нуф", "Ветки деревьев");
    }

    public void run() {
        System.out.println(getPigName() + " начал строить дом из " + getMaterial());
        try {
            Thread.sleep(800);
            System.out.println(getPigName() + " построил дом из " + getMaterial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
