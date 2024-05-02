package task16;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Comment {
    private Long id;
    private String textCom;
    private Date date;
    private String author;
}