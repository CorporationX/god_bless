package faang.school.godbless.sprint_3.multithreading_synchronization.task_7_tinder;

import java.util.List;
import java.util.Optional;

public class ChatManager {
    public static final int TIME_CHATTING = 3000;
    public static final long TIME_OUT_FOR_WAIT = 2000;
    public static final String MSG_EXIT = "Выключили";

    private final UserList userList;
    private final List<Chat> chatList;
    private boolean isActive = true;

    public void setActiveOff() {
        System.out.println(MSG_EXIT);
        isActive = false;
    }

    public ChatManager(UserList userList, List<Chat> chatList) {
        this.userList = userList;
        this.chatList = chatList;
    }

    public void startChat(User initiator) throws InterruptedException {
        // Если user уже успел с кем-то початиться и выйти, то сразу его на выход.
        // Цикли нужен на случай, если после общения, пользователь не вышел, а остаётся в онлайне.
        EXIT:
        while (isActive && initiator.getStatus() != Status.OFFLINE) {

            // Если пользователь уже в чате, то просто ждём его завершения,
            if (initiator.getStatus() == Status.CHATTING) {
                // сюда прорвуться оба потока пользователей, которые в чате,
                // но один удалит чат, а второй получит случайный статус и продолжит работать(если не OFFLINE)
                waitForChat(initiator);

                // иначе ищем собеседника
            } else {
                Chat chat = null;

                // лочим лист пользователей, чтобы безопасно найти пару для чата
                synchronized (userList) {

                    // Цикл нужен, чтобы обновлять список пользователей в онлайне,
                    // если в userList добавится новый пользователь.
                    while (true) {
                        // Если в ожидании собеседника инициатор разговора вышел, то выходим из приложения.
                        if (initiator.getStatus() == Status.OFFLINE) {
                            break EXIT;
                        }

                        // список пользователей в онлайне (кроме инициатора)
                        List<User> onlineUsers = getOnlineUsers(initiator);

                        // ищем пользователя, желающего пообщаться.
                        // Если никого нет, то освобождаем монитор и ждём.
                        Optional<User> userForChat = findUserForChat(onlineUsers);
                        if (userForChat.isEmpty()) {
                            userList.wait(TIME_OUT_FOR_WAIT);
                        } else {
                            // Отправляем пользователей в чат.
                            chat = new Chat(initiator, userForChat.get());
                            break;
                        }
                    }
                }

                // добавляем чат в список
                chatList.add(chat);

                // пользователи чатяться, пока другие потоки работают.
                Thread.sleep(TIME_CHATTING);
                endChat(chat);

            }
        }
    }

    public synchronized void waitForChat(User initiator) throws InterruptedException {
        Optional<Chat> chatOptional = findChatByUser(initiator);
        // Если пользователя уже добавили в чат, то просто ждём его завершения
        if (chatOptional.isPresent()) {
            // Если мы передали список чатов, то нужен вот такой костыль
            Thread.sleep(TIME_CHATTING);
            endChat(chatOptional.get());
        }
    }

    public void endChat(Chat chat) {
        synchronized (userList) {
            // Если чат есть в списке
            Optional<Chat> chatClose = findChatById(chat.getChatId());
            if (chatClose.isPresent()) {
                // то удаляем его
                chatList.remove(chat);
                // случайным образом устанавливаем новые статусы
                chatClose.get().changeStatusAfterChatClose();
                System.out.printf("Чат %d закрыт.\n", chat.getChatId());
                // размораживаем ждунов, хотя они сами могут разморозиться.
                userList.notifyAll();
            }
        }
    }

    private Optional<Chat> findChatById(int chadId) {
        return chatList.stream()
                .filter(c -> c.getChatId() == chadId)
                .findFirst();
    }

    // поиск первого пользователя, который хочет общаться
    private Optional<User> findUserForChat(List<User> usersOnline) {
        return usersOnline.stream()
                .filter(u -> u.getStatus() == Status.LOOKING_FOR_CHAT)
                .findFirst();
    }

    // поиск незавершенного чата, в котором участвует пользователь.
    private Optional<Chat> findChatByUser(User user) {
        synchronized (chatList) {
            return chatList.stream()
                    .filter(c -> c.userInChat(user))
                    .findFirst();
        }
    }

    public List<User> getOnlineUsers(User initiator) {
        synchronized (userList) {
            return userList.users.stream()
                    .filter(u -> u.isOnline() && !u.equals(initiator))
                    .toList();
        }
    }
}
