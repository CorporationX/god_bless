package school.faang.bjs246205;

import java.nio.file.FileAlreadyExistsException;

public class FileUpload {

    public static String uploadFile(String pathFile) throws Exception {
        throw new FileAlreadyExistsException("This file already exists " + pathFile);
    }
}