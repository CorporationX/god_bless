package finally_a_normal_game;

public class Pig1Thread extends PigThread{
    public Pig1Thread(){
        setPigName(NamePig.NIF_NIF);
        setMaterial(Materials.STRAW);
    }
    public void run(){
        System.out.println("Nif-Nif started building a house out of straw");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Nif-Nif built from straw");
    }
}
