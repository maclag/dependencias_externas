package application;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Application {

    public static void main (String[] args) {

        String inputJavaClass = "src/main/resources/java_class.txt";
        String inputBDClass = "src/main/resources/bd_class.txt";

        readFile(inputJavaClass);
        System.out.println();
        readFile(inputBDClass);

    }

    private static void readFile (String path) {
        File file = new File(path);
        try {
            List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
