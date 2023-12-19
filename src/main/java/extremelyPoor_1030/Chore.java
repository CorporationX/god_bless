package extremelyPoor_1030;

public class Chore implements Runnable {
    private String nameTask;

    public Chore(String nameTask) {
        this.nameTask = nameTask;
    }

    @Override
    public void run() {

        String nameThread = Thread.currentThread().getName();
        System.out.println("Запущен поток - '" + nameThread + "' для задачи - " + nameTask);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(nameTask + " - завершена");
    }
}