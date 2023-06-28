package finally_a_normal_game;

public class Pig2Thread extends PigThread {
    public Pig2Thread(){
        setPigName(NamePig.NUF_NUF);
        setMaterial(Materials.STICKS);
    }
    public void run(){
        System.out.println("Nuf-Nuf started building a house out of sticks");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Nuf-Nuf built from sticks");
    }
}
