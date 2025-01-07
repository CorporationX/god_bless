package derschrank.sprint03.task13.bjstwo_49141;

public interface ChatManagerInterface {
    void startChat(User forUser);

    void waitForChat(User forUser);

    void endChat(Chat chat);

    boolean isNotActiveChats();
}
