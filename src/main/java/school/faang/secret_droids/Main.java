package school.faang.secret_droids;

public class Main {
    public static void main(String[] args) {
        Droid c3po = new Droid("c3po");
        Droid r2d2 = new Droid("r2d2");
        c3po.sendMessage("new messge pi-pi-r33", 2, r2d2);
    }
}
