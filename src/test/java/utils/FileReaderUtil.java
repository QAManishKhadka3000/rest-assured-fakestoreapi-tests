package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtil {
    public static String readFile(String filePath) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get("src/test/resources/" + filePath));
        return new String(content, StandardCharsets.UTF_8);
    }
}