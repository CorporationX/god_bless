package faang.school.godbless.Syncrhonization.Youtube;

import java.util.UUID;

public class RandomIdGenerator {
    public static String generateId(String videoId) {
        // Генерируем уникальный идентификатор на основе текущего времени и videoId
        String uniqueId = UUID.randomUUID().toString();

        // Добавляем videoId к уникальному идентификатору
        String idWithVideoId = uniqueId + "-" + videoId;

        return idWithVideoId;
    }

    public static void main(String[] args) {
        String videoId = "example_video_id";
        String randomId = generateId(videoId);
        System.out.println("Random ID for videoId '" + videoId + "': " + randomId);
    }
}

