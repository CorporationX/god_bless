package school.faang.bjs2_37814;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int emailsPerThread = 200;

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++){
            int startIndex = i * emailsPerThread;
            int endIndex = startIndex + emailsPerThread - 1;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);

            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }
        for(int i = 0; i < 5; i++){
            try{
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("All emails been send ");
    }
}
