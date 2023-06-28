package finally_a_normal_game;

public class Pig3Thread extends PigThread{
    public Pig3Thread(){
        setPigName(NamePig.NAF_NAF);
        setMaterial(Materials.BRICKS);
    }
    public void run(){
        System.out.println("Naf-Naf started building a house out of bricks");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Naf-Naf built from bricks");
    }
}
