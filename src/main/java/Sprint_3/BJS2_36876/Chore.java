package Sprint_3.BJS2_36876;

public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Выполняет задачу: " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        System.out.println("Задача \"" + chore + "\" была прервана.");
        Thread.currentThread().interrupt();
        return;
    }
        System.out.println(Thread.currentThread().getName() + " завершил задачу: " + chore);
}

}
