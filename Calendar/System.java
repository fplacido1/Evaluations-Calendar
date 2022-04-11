package Calendar;

public interface System {
    void addTeacher(String name);

    void addStudent(String name, int number);

    void  addCourse(String name);

    void assignTeacher(String courseName, String name);

    void enrolStudent(String courseName, String name);
    
}
