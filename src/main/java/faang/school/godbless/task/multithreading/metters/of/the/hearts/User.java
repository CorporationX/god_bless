package faang.school.godbless.task.multithreading.metters.of.the.hearts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@RequiredArgsConstructor
public class User {
    private static final int SLEEP_TIME_OUT = 5000;

    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> scheduledFuture;
    private final long id;
    private final String name;
    private final UserList userList;
    private final ChatManager chatManager;
    private boolean isOnline;
    private boolean isWantChat;
    private boolean isAsleep;
    private boolean timerIsOn;
    private Chat chat;

    public Optional<Chat> getChat() {
        return Optional.ofNullable(chat);
    }

    public synchronized void online() {
        log.info("{} online", this);
        if (scheduler.isShutdown()) {
            scheduler = Executors.newSingleThreadScheduledExecutor();
        }
        isOnline = true;
        userList.addOnlineUser(this);
    }

    public synchronized void offline() {
        userList.removeOnlineUser(this);
        isOnline = false;
        log.info("{} offline", this);
        leaveChat();
        stopLookingForChat();
        cancelAwakeTimer();
        scheduler.shutdownNow();
    }

    public void findChat() {
        online();
        if (chat == null || !chat.isAlive()) {
            find();
        } else {
            log.info("{} уже в чате с {}", this, chat.getOpponent(this));
        }
    }

    private void find() {
        log.info("{} хочет начать чат", this);
        isWantChat = true;
        if (!chatManager.startChat(this)) {
            waitForChat();
        }
    }

    public void closeChat() {
        chatCloseMessage();
        leaveChat();
    }

    private void leaveChat() {
        if (chat != null) {
            chat.leave(this);
            chat = null;
        }
    }

    private void chatCloseMessage() {
        log.info("{} хочет покинуть чат", this);
        if (chat == null) {
            log.info("У пользователя {} нет чата", this);
        } else if (chat.isAlive()) {
            log.info("{} покидает чат с {}", this, chat.getOpponent(this));
        } else {
            log.info("{} покидает пустой чат", this);
        }
    }

    public void assignChat(Chat chat) {
        chatFound();
        leaveChat();
        this.chat = chat;
        log.info("У {} новый чат с {}", this, chat.getOpponent(this));
    }

    private synchronized void chatFound() {
        isWantChat = false;
        log.info("{} нашел и больше не ищет чат", this);
    }

    private void waitForChat() {
        log.info("{} не нашел чат и перешел в режим ожидания", this);
        sleep();
        cancelAwakeTimerIfOn();
        messageAfterSleep();
        if (chat == null || !chat.isAlive()) {
            stopLookingForChat();
        }
    }

    private void sleep() {
        synchronized (this) {
            isAsleep = true;
            try {
                awakeByTimer();
                this.wait();
            } catch (InterruptedException e) {
                log.error("Interrupted exception: {}", e.getMessage());
                Thread.currentThread().interrupt();
            }
            isAsleep = false;
        }
    }

    private synchronized void awakeByTimer() {
        timerIsOn = true;
        scheduledFuture = scheduler.schedule(() -> {
            log.info("Вышло время ожидания нового чата, для пользователя: {}", this);
            notifyUser();
            timerIsOn = false;
        }, SLEEP_TIME_OUT, TimeUnit.MILLISECONDS);
    }

    private synchronized void cancelAwakeTimerIfOn() {
        if (timerIsOn) {
            cancelAwakeTimer();
        }
    }

    private synchronized void cancelAwakeTimer() {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
            log.info("{}, запущенный таймер для пробуждения потока отключен", this);
        }
    }

    private void messageAfterSleep() {
        if (chat != null && chat.isAlive()) {
            log.info("{} вышел из режима ожидания для общения с {}", this, chat.getOpponent(this));
        } else {
            log.info("{} не дождался собеседника и вышел из режима ожидания", this);
        }
    }

    private synchronized void stopLookingForChat() {
        if (isWantChat) {
            isWantChat = false;
            log.info("{} прекратил поиски чата", this);
        }
    }

    public void notifyUser() {
        synchronized (this) {
            this.notifyAll();
        }
    }

    @Override
    public String toString() {
        return name + ".";
    }
}
