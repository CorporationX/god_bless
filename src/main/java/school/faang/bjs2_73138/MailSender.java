package school.faang.bjs2_73138;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        int lettersPerThread = 200;

        for(int i = 0; i < 5; i++) {
            String name = "Поток - " + i;
            int start = i * lettersPerThread + 1;
            int end = (i + 1) * lettersPerThread;
            threads[i] = new Thread(new SenderRunnable(start, end), name);
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Поток прерван: " + threads[i].getName());
            }
        }

        System.out.println("Все письма успешно отправлены!");

    }
}
