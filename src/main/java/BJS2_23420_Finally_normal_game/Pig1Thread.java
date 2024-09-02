package BJS2_23420_Finally_normal_game;

public class Pig1Thread extends PigThread {
    @Override
    public void run() {
        setPigName("Ниф-Ниф");
        setMaterial(100);
        buildHome();
    }
}
