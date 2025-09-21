package school.faang.multithreading.parallelism_thread.bjs2_91292;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", "солома");
    }

    @Override
    public void run() {
        buildThread(1000);
    }
}
