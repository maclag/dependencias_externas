package application;

import group.StudyClass;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Application {

    public static void main (String[] args) {
        String inputJavaClass = "src/main/resources/input/java_class.txt";
        String inputBDClass = "src/main/resources/input/bd_class.txt";

        String outputJavaClass = "src/main/resources/output/java_students.txt";
        String outputBDClass = "src/main/resources/output/bd_students.txt";
        String outputStudents = "src/main/resources/output/students.txt";

        StudyClass javaClass = new StudyClass("Java");
        StudyClass bdClass = new StudyClass("Banco de Dados");

        javaClass.writeClassFile(inputJavaClass, outputJavaClass);
        bdClass.writeClassFile(inputBDClass, outputBDClass);
        writeStudentsFile(outputStudents, javaClass, bdClass);
    }

    public static void writeStudentsFile (String outputPath, StudyClass class1, StudyClass class2) {
        File outputFile = new File(outputPath);

        Set<String> studentsListFormatted = new TreeSet<>();
        CollectionUtils.addAll(studentsListFormatted, class1.getStudentsName());
        CollectionUtils.addAll(studentsListFormatted, class2.getStudentsName());

        int allStudentsQuantity = studentsListFormatted.size();

        List<String> students = new ArrayList<>(studentsListFormatted);

        students.add(0, "LISTA DE TODOS OS ALUNOS DA ESCOLA:");
        students.add(1, "- Quantidade de alunos: " + allStudentsQuantity + "\n");

        try {
            FileUtils.writeLines(outputFile, StandardCharsets.UTF_8.name(), students);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
