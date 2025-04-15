package school.faang.bjs_70518;

public class Main {
    public static void main(String[] args) {
        Droid r2 = new Droid("R2");
        Droid c3po = new Droid("C3-PO");
        Droid vega = new Droid("Vega");

        vega.sendMessage("Hello", 2, c3po);
        c3po.sendMessage("Kill meatbags", 2, vega);
    }
}
