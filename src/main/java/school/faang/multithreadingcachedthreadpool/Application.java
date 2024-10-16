package school.faang.multithreadingcachedthreadpool;

public class Application {
    public static void main(String[] args) {
        WeasleyFamily family = new WeasleyFamily();
        family.addChore(new Chore("wash the floor"));
        family.addChore(new Chore("cook dinner", 2000));
        family.addChore(new Chore("cook breakfast", 500));
        family.addChore(new Chore("wash the dishes", 1250));
        family.doChores();
    }
}
