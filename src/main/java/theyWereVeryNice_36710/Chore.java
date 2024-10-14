package theyWereVeryNice_36710;

public record Chore(String chore) implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задание: " + chore);
            Thread.sleep(3000);
            System.out.println("--------Задание \"" + chore + "\" выполнено---------");
        } catch (InterruptedException e) {
            System.out.println("Задание \"" + chore + "\" было прервано.");
        }
    }
}
