package normGame_36637;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread pigNifNif = new Pig1Thread("Ниф-Ниф", "солома");
        PigThread pigNufNuf = new Pig2Thread("Нуф-Нуф", "палки");
        PigThread pigNafNaf = new Pig3Thread("Наф-Наф", "кирпичи");


        pigNifNif.start();
        pigNufNuf.start();
        pigNafNaf.start();

        try {
            pigNifNif.join();
            pigNufNuf.join();
            pigNafNaf.join();
            System.out.println("Игра завершена!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
