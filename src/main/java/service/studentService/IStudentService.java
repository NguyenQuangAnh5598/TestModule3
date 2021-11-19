package service.studentService;

import module.Student;

import java.util.List;

public interface IStudentService {
    List<Student> showAllStudent();
    public Student selectStudentByID(int id);
}
