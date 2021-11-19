package service.studentService;

import config.ConnectSingleton;
import module.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String query = "call selectStudentByID(?);";
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
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
