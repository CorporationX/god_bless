package faang.school.godbless.BJS2_914;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Image {
    private String fileName;
    private String description;

    public String toString(){
        return getFileName()+", "+getDescription();
    }
}
