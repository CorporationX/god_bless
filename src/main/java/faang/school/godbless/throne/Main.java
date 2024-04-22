package faang.school.godbless.throne;

public class Main {
    public static void main(String[] args) {
        House stark = new House();
        User tom = new User("Tom", stark, "Эддард");
        User ann = new User("Ann", stark, "Кейтлин");
        User max = new User("Max", stark, "Робб");
        User nina = new User("Nina", stark, "Санса");
        User mary = new User("Mary", stark, "Арья");
        User bob = new User("Bob", stark, "Бран");
        Thread tomThread = new Thread(() -> tom.joinHouse(stark));
        Thread annThread = new Thread(() -> ann.joinHouse(stark));
        Thread maxThread = new Thread(() -> max.joinHouse(stark));
        Thread ninanThread = new Thread(() -> nina.joinHouse(stark));
        Thread maryThread = new Thread(() -> mary.joinHouse(stark));
        tomThread.start();
        annThread.start();
        maxThread.start();
        ninanThread.start();
        maryThread.start();
        try {
            tomThread.join();
            annThread.join();
            maxThread.join();
            ninanThread.join();
            maryThread.join();
            Thread leaveThread = new Thread(() -> tom.leaveHouse(stark));
            leaveThread.start();
            leaveThread.join();
            Thread bobThread = new Thread(() -> bob.joinHouse(stark));
            bobThread.start();
            bobThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
