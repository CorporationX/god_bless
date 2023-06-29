package they_were_very_nice_but_extremely_poor;

public class Chore implements Runnable{
    private String chore;
    public Chore(String chore){
        this.chore = chore;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+" Выполняется задача: "+chore);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Задача "+chore+" выполнена");
    }
}
