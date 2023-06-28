package sprint4.harrypotter;

public record Chore(String chore) implements Runnable {

    @Override
    public synchronized void run() {
        System.out.printf("� ������ %s �� ��������� ������ �� ����: %s\n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
        System.out.printf("������ � ������ %s - \"%s\" ���������!\n", Thread.currentThread().getName(), chore);
    }
}
