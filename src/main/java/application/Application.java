package application;

import group.StudyClass;

public class Application {

    public static void main (String[] args) {
        String inputJavaClass = "src/main/resources/input/java_class.txt";
        String inputBDClass = "src/main/resources/input/bd_class.txt";

        String outputJavaClass = "src/main/resources/output/java_students.txt";
        String outputBDClass = "src/main/resources/output/bd_students.txt";


        StudyClass javaClass = new StudyClass("Java");
        StudyClass bdClass = new StudyClass("Banco de Dados");

        javaClass.writeClassFile(inputJavaClass, outputJavaClass);
        bdClass.writeClassFile(inputBDClass, outputBDClass);
    }

}
