package faang.school.godbless.sprint_3.multithreading_synchronization.task_7_tinder;

public class Chat {
    private final int chatId;

    private static int chatsCount;
    private final User firstUser;
    private final User secondUser;

    public Chat(User firstUser, User secondUser) throws InterruptedException {
        this.chatId = ++chatsCount;
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        chatting();
    }

    public int getChatId() {
        return chatId;
    }

    // Является ли пользователь участником чата
    public boolean userInChat(User user) {
        return firstUser.equals(user) || secondUser.equals(user);
    }

    // Имитация переписки. Меняем статусы пользователям и усыпляем поток.
    public void chatting() {
        System.out.printf("Пользователи %s и %s в чате %d.\n", firstUser.getName(), secondUser.getName(), chatId);
        firstUser.setStatus(Status.CHATTING);
        secondUser.setStatus(Status.CHATTING);
    }

    // после завершения чата присваиваем пользователям случайные статусы.
    public void changeStatusAfterChatClose() {
        firstUser.setRandomStatus();
        secondUser.setRandomStatus();
    }
}
