package sprint5.moth;

import lombok.Data;

@Data
public class Chat {
    private boolean isReady = false;
    private boolean isChatting = false;

    public void startChat(User firstUser, User secondUser) {
        isChatting = true;
        System.out.printf("%s and %s are talking.\n", firstUser.getName(), secondUser.getName());
        chatProcess();
        System.out.printf("%s and %s have finished talking.\n", firstUser.getName(), secondUser.getName());
    }

    public void endChat(User firstUser, User secondUser) {
        isChatting = false;
        firstUser.offline();
        secondUser.offline();
    }

    public void chatIsReady() {
        isReady = true;
    }

    public void chatIsNotReady() {
        isReady = false;
    }

    private static void chatProcess() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
