package BJS2_12360;

record Task(String name, String task) implements Runnable{
    @Override
    public void run() {
        System.out.printf("The task %s started \n", task);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted during task: %s \n", name, task);
            Thread.currentThread().interrupt();
        }
    }
}