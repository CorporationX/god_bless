package school.faang.telegram;


import lombok.extern.slf4j.Slf4j;

import static school.WaitUtils.sleep;
import static school.WaitUtils.threadWait;

@Slf4j
public class SendService {

    private static final int MESSAGE_SEND_PROCESS_MILLIS = 200;
    private boolean serviceActive = false;
    private final TelegramBot bot;
    private final String name;
    private final Object botLock;

    public SendService(String name, TelegramBot bot) {
        this.name = name;
        this.bot = bot;
        this.serviceActive = false;
        this.botLock = bot.getBotLock();
    }

    public void activateService() {
        log.info("Activate send service {}", name);
        serviceActive = true;
        while (serviceActive) {
            sendMessage();
        }
    }

    public void deactivateBot() {
        log.info("Deactivate service");
        synchronized (botLock) {
            if (!bot.messagesNotPresent()) {
                log.info("Wait all messages is send");
                threadWait(botLock);
            }
            log.info("Turn off send service");
            serviceActive = false;
            log.info("Notify empty poll handle");
            botLock.notify();
        }
    }

    public void sendMessage() {
        emptyMessagePollHandle();
        if (!serviceActive) {
            return;
        }
        Message messageToSend = bot.provideMessage();
        log.info("{} start sending: {}", name, messageToSend.content());
        sleep(MESSAGE_SEND_PROCESS_MILLIS);
        log.info("{} send: {}", name, messageToSend.content());
        synchronized (botLock) {
            if (bot.messagesNotPresent()) {
                notify();
            }
        }
    }

    private void emptyMessagePollHandle() {
        synchronized (botLock) {
            if (bot.messagesNotPresent()) {
                log.info("{} waiting new messages", name);
                threadWait(botLock);
            }
        }
    }
}
