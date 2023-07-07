package faang.school.godbless.mattersHeart;

public record Chat(User user1, User user2) {
    public void startChat() {
        synchronized (this) {
            System.out.println("[Chat] Chat started between " + user1.name() + " and " + user2.name());
        }
    }

    public void endChat() {
        synchronized (this) {
            System.out.println("[Chat] Chat ended between " + user1.name() + " and " + user2.name());
        }
    }

    public boolean containsUser(User user) {
        return user1.equals(user) || user2.equals(user);
    }
}
