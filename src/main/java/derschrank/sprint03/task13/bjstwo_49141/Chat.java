package derschrank.sprint03.task13.bjstwo_49141;

public record Chat(
    User user1,
    User user2
) {
    public void end() {
        user1.leaveFromChat();
        user2.leaveFromChat();
    }

    public void chating() {
        ChatManagerService.logChatting(this);
        try {
            Thread.sleep(ChatManagerService.TIME_FOR_CHATTING_MILLIS);
        } catch (InterruptedException e) {
            ChatManagerService.logChattingWasInterrupted(this, e);
        }
    }

    @Override
    public String toString() {
        return "Chat between " + user1 + " and " + user2;
    }
}
