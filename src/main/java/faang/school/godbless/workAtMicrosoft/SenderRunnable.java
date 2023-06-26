import lombok.AllArgsConstructor;

@AllArgsConstructor
    public class SenderRunnable implements Runnable{
        private int startIndex;
        private int endIndex;
        private int thread;

        @Override
        public void run() {
            for (int i=startIndex; i<= endIndex; i++){
                System.out.println("Отправлено письмо номер - "+i+" - Потока - "+thread);
            }
        }
    }
