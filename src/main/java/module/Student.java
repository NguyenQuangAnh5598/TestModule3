package module;

public class Student {
    private int id;
    private String studentCode;
    private String studentName;
    private String grade;

    public Student(){}

    public Student(String studentCode, String studentName, String grade) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.grade = grade;
    }

    public Student(int id, String studentCode, String studentName, String grade) {
        this.id = id;
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
