package Peoples;

public class Teachers extends PeopleClass{

    private static final String TEACHERS = "Teacher";

    private int numberOfStudents;

    public Teachers(String name) {
      this.name = name;
      this.type = TEACHERS;
      this.numberOfStudents = 0;
    }

    public void addStudents(int students){
      numberOfStudents += students;
    }

    public int getNumberOfStudents(){
      return numberOfStudents;
    }
    
}
