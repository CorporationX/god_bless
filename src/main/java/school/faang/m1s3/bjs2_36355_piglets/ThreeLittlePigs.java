package school.faang.m1s3.bjs2_36355_piglets;

import java.util.Arrays;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread[] pigs = {new Pig1Thread(), new Pig2Thread(), new Pig3Thread()};

        Arrays.stream(pigs).forEach(PigThread::start);

        Arrays.stream(pigs).forEach(pig -> {
            try {
                pig.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("\nOur houses are finished");
        System.out.println("Hey, Wolf, f*ck off!!");
    }
}
