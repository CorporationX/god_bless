package school.faang.multithreading.parallelism_thread.bjs2_91292;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Наф-Наф", "палки");
    }

    @Override
    public void run() {
        buildThread(2000);
    }
}
