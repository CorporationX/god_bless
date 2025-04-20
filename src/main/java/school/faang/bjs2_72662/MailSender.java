package school.faang.bjs2_72662;

class MailSender {
    public static void main(String[] args) {
        for (int threadCount = 0; threadCount < 5; threadCount++) {
            Thread thread = new Thread(new SenderRunnable());
            thread.start();
        }
    }
}
