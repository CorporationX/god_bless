package school.faang.multithreading_parallelism_thread.bjs2_91292;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Нуф-нуф", "кирпичи");
    }

    @Override
    public void run() {
        buildThread(3000);
    }
}
