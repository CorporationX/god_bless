package faang.school.godbless.BJS2_25412;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double d = 54.456734;
        System.out.println(d);
        double t = new Random().nextDouble(-0.000020,0.000040);
        System.out.println(Math.round((d+t)*1000000.0)/1000000.0);
//        double m = Math.round(t*1000000.0)/1000000.0;
//        System.out.println(new DecimalFormat("0.######").format(m));
    }
}
