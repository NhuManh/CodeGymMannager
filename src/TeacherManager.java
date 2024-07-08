import java.util.ArrayList;
import java.util.List;

public class TeacherManager {
    private List<Teacher> teachers;

    public TeacherManager() {
        teachers = new ArrayList<Teacher>();
    }
    // them moi
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    // hiem thi
    public List<Teacher> getAllTeachers() {
        return teachers;
    }
}
