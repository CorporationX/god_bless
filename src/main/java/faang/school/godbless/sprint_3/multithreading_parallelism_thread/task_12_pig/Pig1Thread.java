package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_12_pig;

public class Pig1Thread extends PigThread{

    public Pig1Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.printf("%s строит дом\n", pigName);
        try {
            sleep(material * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s достроил дом\n", pigName);
    }
}
