package school.faang.mini.zoom;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        System.out.println("Участник " + name + " присоединился к конференции");
        conference.join();
        watchTranslation();
    }

    public void watchTranslation() {
        System.out.println("Пользователь " + name + " смотрит трансляцию");
    }
}
