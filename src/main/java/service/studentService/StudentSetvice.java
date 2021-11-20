package service.studentService;

import config.ConnectSingleton;
import module.Student;

import java.sql.*;
import java.util.List;

public class StudentSetvice implements IStudentService {
    private List<Student> studentList;

    private Connection connection = ConnectSingleton.getConnection();

    @Override
    public List<Student> showAllStudent() {
        return null;
    }

    @Override
    public Student selectStudentByID(int id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String studentCode = rs.getString(2);
                String studentName = rs.getString(3);
                String gradeName = rs.getString(4);
                student = new Student(id,studentCode,studentName,gradeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
