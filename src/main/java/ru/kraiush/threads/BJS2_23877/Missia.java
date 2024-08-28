package ru.kraiush.threads.BJS2_23877;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Missia implements Runnable {

    private String roomName;

    public Missia(String roomName) {
        this.roomName = roomName;
    }

    private List<Food> listfoods;

    @Override
    public void run() {
        System.out.println(roomName + " room -> " + Thread.currentThread().getName() + " --- Start at: " + new Date());
        tekeTheFood();
        System.out.println(roomName + " room -> " + Thread.currentThread().getName() + " --- End at: " + new Date());
    }

    private void tekeTheFood() {
        try {
            Thread.sleep(1000);
            listfoods.stream()
                    .map(e -> {
                        try {
                            Thread.sleep(100 * e.getAmount());
                        } catch (InterruptedException ex) {
                            return Optional.empty();
                        }
                        return e;
                    });
            listfoods = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
