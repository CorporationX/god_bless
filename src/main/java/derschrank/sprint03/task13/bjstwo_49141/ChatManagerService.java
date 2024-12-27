package derschrank.sprint03.task13.bjstwo_49141;

public class ChatManagerService {
    public static final int TIME_FOR_CHATTING_MILLIS = 2000;

    public static void logChatIsMade(Chat chat) {
        System.out.println("+ Chat is made: " + chat);
    }

    public static void logChatIsEnded(Chat chat) {
        System.out.println("- Chat is ended: " + chat);
    }
    public static void logChatIsNotMade(User forUser, User withUser) {
        System.out.printf(" / Chat isn't made for users: %s and %s%n", forUser, withUser);
    }

    public static void logUserAwait(User forUser) {
        System.out.printf("Now user: %s is await for a notification for release any user" +
                " or invitation for other chat%n", forUser);
    }

    public static void logUserAwaitWasInterrupted(User forUser, Exception e) {
        System.out.printf(" / Await for user: %s was interrupted.%n%s", forUser, e);
    }

    public static void logChatting(Chat chat) {
        System.out.printf(" . Chatting... %s%n", chat);
    }

    public static void logChattingWasInterrupted(Chat chat, Exception e) {
        System.out.printf("/ %s was interrupted.%n%s", chat, e);
    }
}
