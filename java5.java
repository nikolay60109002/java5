public class Student {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Teacher {
    private final int id;
    private final String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class LearningGroup {
    private final Teacher teacher;
    private final List<Student> students;

    public LearningGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}

public class LearningGroupService {
    public static LearningGroup createLearningGroup(Teacher teacher, List<Student> students) {
        return new LearningGroup(teacher, students);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearningGroupController {
    private final List<Integer> studentIds;
    private final Integer teacherId;

    public LearningGroupController(List<Integer> studentIds, Integer teacherId) {
        this.studentIds = studentIds;
        this.teacherId = teacherId;
    }

    public LearningGroup getLearningGroup() {
        List<Student> students = new ArrayList<>();
        for (int studentId : studentIds) {
            students.add(new Student(studentId, "Student " + studentId));
        }

        Teacher teacher = new Teacher(teacherId, "Teacher " + teacherId);
        return LearningGroupService.createLearningGroup(teacher, students);
    }
}

public class App {
    public static void main(String[] args) {
        List<Integer> studentIds = Arrays.asList(1, 2, 3);
        Integer teacherId = 4;

        LearningGroupController controller = new LearningGroupController(studentIds, teacherId);
        LearningGroup learningGroup = controller.getLearningGroup();

        System.out.println("Преподаватель: " + learningGroup.getTeacher().getName());
        System.out.println("Студенты: [" + String.join(", ", learningGroup.getStudents().stream()
                .map(Student::getName).toArray()) + "]");
    }
}
