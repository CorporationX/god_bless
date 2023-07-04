package faang.school.godbless.they_were_very_nice;

public class Chore implements Runnable{
    String chore;

    public Chore(String chore){
        this.chore = chore;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " выполняет: " + chore);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(chore + " - завершено потоком: " + threadName);
    }
}
