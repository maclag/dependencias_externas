package group;

import lombok.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class StudyClass {

    private final String className;
    public final List<Student> classStudents = new ArrayList<>();
    public final List<String> studentsName = new ArrayList<>();

    private void addStudent (String name) {
        Student student = new Student(name);

        this.classStudents.add(student);
        this.studentsName.add(student.getName());
    }

    private List<String> readClassFile (String inputPath) {
        List<String> students = new ArrayList<>();

        try {
            students = FileUtils.readLines(new File(inputPath), StandardCharsets.UTF_8);
            students.forEach(this::addStudent);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file in this directory!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(students);

        return students;
    }

    public void writeClassFile (String inputPath, String outputPath) {
        List<String> students = readClassFile(inputPath);
        File outputFile = new File(outputPath);
        int studentQty = students.size();

        students.add(0, "LISTA DE ALUNOS DA TURMA DE " + this.className.toUpperCase() + ":");
        students.add(1, "- Quantidade de alunos: " + studentQty + "\n");

        try {
            FileUtils.writeLines(outputFile, StandardCharsets.UTF_8.name(), students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
