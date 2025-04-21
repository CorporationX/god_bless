package school.faang.parallelism_3_1.bjs2_72662;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MailSender {
    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        Thread[] threads = new Thread[config.getThreadsCount()];

        for (int threadInd = 0; threadInd < config.getThreadsCount(); threadInd++) {
            int startInd = threadInd * config.getBatchSize();
            int endInd = (threadInd + 1) * config.getBatchSize();
            threads[threadInd] = new Thread(new SenderRunnable(startInd, endInd));
            threads[threadInd].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        log.info("Все письма отправлены");
    }
}
