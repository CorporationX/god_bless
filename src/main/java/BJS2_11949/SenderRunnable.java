package BJS2_11949;

record SenderRunnable(int startIndex, int endIndex) implements Runnable{
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Сообщение %d отправлено \n", i);
        }
    }
}