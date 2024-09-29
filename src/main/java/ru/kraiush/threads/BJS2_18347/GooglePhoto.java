package ru.kraiush.threads.BJS2_18347;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GooglePhoto {

    private String name;
    private String photoPath;

    public GooglePhoto(String name) {
        this.name = name;
    }
}
