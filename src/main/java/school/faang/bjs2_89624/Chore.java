package school.faang.bjs2_89624;

public record Chore(String choreName) implements Runnable {
    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.printf("Поток Перси \"%s\" выполняет задачу \"%s\"\n", currentThreadName, choreName);
        try {
            Thread.sleep(5000);
            System.out.printf("Отлично! Поток \"%s\" справился с задачей!\n", currentThreadName);
        } catch (InterruptedException e) {
            System.out.printf("Поток \"%s\" был прерван во время работы!\n", currentThreadName);
            Thread.currentThread().interrupt();
        }
    }
}
