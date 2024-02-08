package java.com.Java8.newfeature.UdemyLearn.streams;

import java.com.Java8.newfeature.UdemyLearn.Database.Student;
import java.com.Java8.newfeature.UdemyLearn.Database.StudentDataBase;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    public static List<String> printStudentActivities () {
        final List<Student> studentActivities = StudentDataBase.getAllStudents();
        final List<String> collect = studentActivities.stream()
                .peek(i -> System.out.println(i))
                .map(Student::getActivities)
                .peek(i -> System.out.println(i))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        printStudentActivities();
    }
}
