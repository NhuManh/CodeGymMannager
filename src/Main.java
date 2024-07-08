import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Quản lý học viên");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Thoát");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageStudents(studentManager, scanner);
                    break;
                case 2:
                    manageTeachers(teacherManager, scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void manageStudents(StudentManager studentManager, Scanner scanner) {
        while (true) {
            System.out.println("----Student Management----");
            System.out.println("1. Thêm học viên.");
            System.out.println("2. Hiển thị danh sách học viên");
            System.out.println("3. Sửa thông tin học viên.");
            System.out.println("4. Xóa học viên: ");
            System.out.println("5. Quay lại menu chính.");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(studentManager, scanner);
                    break;
                case 2:
                    displayAllStudents(studentManager);
                    break;
                case 3:
                    editStudent(studentManager,scanner);
                case 4:
                    deleteStudent(studentManager,scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void manageTeachers(TeacherManager teacherManager, Scanner scanner) {
        while (true) {
            System.out.println("----Teacher Management----");
            System.out.println("1. Thêm giảng viên");
            System.out.println("2. Hiển thị danh sách giảng viên");
            System.out.println("3. Quay lại menu chính");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTeacher(teacherManager, scanner);
                    break;
                case 2:
                    displayAllTeachers(teacherManager);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void addStudent(StudentManager studentManager, Scanner scanner) {
        System.out.print("Nhập mã học viên (ID): ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên học viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Nhập tên lớp: ");
        String className = scanner.nextLine();

        Student student = new Student(studentId, name, dateOfBirth, className);
        studentManager.addStudent(student);
        System.out.println("Học viên đã được thêm thành công.");
    }

    private static void displayAllStudents(StudentManager studentManager) {
        if (studentManager.getAllStudents().size() == 0) {
            System.out.println("Chưa có học viên.");
        } else {
            System.out.println("Danh sách học viên:");
            for (Student student : studentManager.getAllStudents()) {
                System.out.println(student);
            }
        }
    }

    private static void addTeacher(TeacherManager teacherManager, Scanner scanner) {
        System.out.print("Nhập mã giảng viên: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên giảng viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        Teacher teacher = new Teacher(teacherId, name, dateOfBirth, email, phone, address);
        teacherManager.addTeacher(teacher);
        System.out.println("Giảng viên đã được thêm thành công.");
    }

    private static void displayAllTeachers(TeacherManager teacherManager) {

        if (teacherManager.getAllTeachers().size() == 0) {
            System.out.println("Chưa có giảng viên.");
        } else {
            System.out.println("Danh sách giảng viên:");
            for (Teacher teacher : teacherManager.getAllTeachers()) {
                System.out.println(teacher);
            }}
    }
    private static void editStudent(StudentManager studentManager, Scanner scanner) {
        System.out.println("----Danh sách học viên----");
        for (Student student : studentManager.getAllStudents()) {
            System.out.println(student);
        }
        System.out.println("Nhập ID học viên cần chỉnh sửa.");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        Student student = studentManager.getStudentById(studentId);
        if (student != null) {
            System.out.println("Đã tìm thấy học viên có ID: " + studentId);
        }
        else{
            System.out.println("Không có học viên có ID: " + studentId);
        }
        System.out.println(student);// Hiển thị học viên tìm được

        System.out.println("Nhập tên mới");
        String name = scanner.nextLine();
        student.setName(name);

        System.out.println("Nhập ngày sinh mới");
        String dateOfBirth = scanner.nextLine();
        student.setDateOfBirth(dateOfBirth);

        System.out.println("Nhập tên lớp mới");
        String className = scanner.nextLine();
        student.setClassName(className);

        System.out.println("Đã cập nhật");
    }

    public static void deleteStudent(StudentManager studentManager, Scanner scanner) {
        for (Student student : studentManager.getAllStudents()) {
            System.out.println(student);
        }
        System.out.println("Nhập Id học viên cần xóa; ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        Student student = studentManager.getStudentById(studentId);
        if (student == null) {
            System.out.println("Không tìm thấy học viên có ID: " + studentId);
        }else{
            System.out.println("Đã tìm thấy học viên"+ student);
            while(true){
                System.out.println("1:Xoá");
                System.out.println("2:Thôi...");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        studentManager.deleteStudentById(studentId);
                        System.out.println("Học viên có Id"+studentId+" đã bay màu.");
                        return;
                    case 2:
                        return;
                    default:
                        System.out.println("Lựa chọn không phù hợp");
                }
            }
        }
    }
}