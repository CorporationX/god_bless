package school.faang.bjs_48984;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UploadServiceTest {

    @Test
    void upload() {
        List<String> files = List.of(
                "G:\\Projects\\Travel\\Paris\\Eiffel Tower.jpg",
                "H:\\Memories\\Family\\Birthday party.jpg",
                "I:\\Documents\\Pictures\\Travel\\Japan\\Tokyo.jpg",
                "J:\\Work\\Presentations\\Case study.jpg",
                "K:\\Music\\Live concerts\\Seattle.jpg",
                "L:\\School\\Projects\\Biology\\Plants.jpg",
                "M:\\Library\\Books\\Illustrations.jpg",
                "N:\\Home\\DIY\\Crafts.jpg",
                "O:\\Gaming\\World of Warcraft\\Skins.jpg",
                "P:\\Movies\\Blockbusters\\Avatar.jpg"
        );
        UploadService service = new UploadService();
        List<String> actual = service.upload(files);
        Assertions.assertEquals(files, actual);
        Assertions.assertTrue(actual.containsAll(files));
        Assertions.assertTrue(files.containsAll(actual));
    }
}