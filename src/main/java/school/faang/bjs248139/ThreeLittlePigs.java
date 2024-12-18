package school.faang.bjs248139;

public class ThreeLittlePigs {

    public static void main(String[] args) throws Exception {

        Pig1Thread nifNif = new Pig1Thread("NifNif", "straw");
        Pig1Thread nufNuf = new Pig1Thread("NufNuf", "sticks");
        Pig1Thread nafnaf = new Pig1Thread("NafNaf", "bricks");

        nifNif.start();
        nufNuf.start();
        nafnaf.start();

        nifNif.join();
        nufNuf.join();
        nafnaf.join();
        System.out.println("All works are done");

    }

}
