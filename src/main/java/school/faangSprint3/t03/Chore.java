package school.faangSprint3.t03;

class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана.");
        }
    }
}
