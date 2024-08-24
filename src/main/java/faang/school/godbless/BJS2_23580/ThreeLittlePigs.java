package faang.school.godbless.BJS2_23580;


import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<PigThread> pigs = List.of(
                new Pig1Thread("Denis", Material.STRAW),
                new Pig2Thread("Andrey", Material.STICKS),
                new Pig3Thread("Sultan", Material.BRICKS)
        );

        pigs.forEach(Thread::start);
        pigs.forEach(pig -> {
            try {
                pig.join();
            } catch (InterruptedException e) {
                pig.interrupt();
            }
        });

        System.out.println("Роберт съел всех поросят!!! мухехеххехе");
    }
}
