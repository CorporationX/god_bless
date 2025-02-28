package school.faang.task_61997;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();

    private Thread lockHolder = null;
    private String currentCommand = "None";

    @SneakyThrows
    public void play() {
        if (isLocked("Play")) {
            logBlockedCommand("Play");
            return;
        }

        synchronized (lock) {
            try {
                currentCommand = "Play";
                log.info("Playing... [Thread: {}]", Thread.currentThread().getId());
            } finally {
                releaseLock();
            }
        }
    }

    @SneakyThrows
    public void pause() {
        if (isLocked("Pause")) {
            logBlockedCommand("Pause");
            return;
        }
        synchronized (lock) {
            try {
                currentCommand = "Pause";
                log.info("Paused... [Thread: {}]", Thread.currentThread().getId());
            } finally {
                releaseLock();
            }
        }
    }

    @SneakyThrows
    public void skip() {
        if (isLocked("Skip")) {
            logBlockedCommand("Skip");
            return;
        }

        synchronized (lock) {
            try {
                currentCommand = "Skip";
                log.info("Skipped... [Thread: {}]", Thread.currentThread().getId());
            } finally {
                releaseLock();
            }
        }
    }

    @SneakyThrows
    public void previous() {
        if (isLocked("Previous")) {
            logBlockedCommand("Previous");
            return;
        }

        synchronized (lock) {
            try {
                currentCommand = "Previous";
                log.info("Previous... [Thread: {}]", Thread.currentThread().getId());
            } finally {
                releaseLock();
            }
        }
    }

    private boolean isLocked(String command) {
        if (lockHolder == null) {
            lockHolder = Thread.currentThread();
            currentCommand = command;
            return false;
        }
        return true;
    }

    private void releaseLock() {
        lockHolder = null;
        currentCommand = "None";
    }

    private void logBlockedCommand(String command) {
        log.info(
                "Block command: {}, Reason: Executing '{}', Thread ID: {}",
                command,
                currentCommand,
                lockHolder != null ? lockHolder.getId() : "None");
    }
}
