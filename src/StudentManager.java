import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Thêm học viên mới
    public void addStudent(Student student) {
        students.add(student);
    }

    // Lấy danh sách học viên
    public List<Student> getAllStudents() {
        return students;
    }

    // Chỉnh sửa thông tin học viên
    // Trả học viên theo Id
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id){
                return student;
            }
        }
        return null;
    }

    // Xóa học viên
    public void deleteStudentById(int id) {
        students.remove(getStudentById(id));
    }

}
