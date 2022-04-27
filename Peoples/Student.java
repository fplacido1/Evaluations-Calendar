package Peoples;

public class Student extends PeopleClass{
    private static final String STUDENT = "Student";

    private int number;

    public Student(String name, int number) {
       this.name = name;
       this.type = STUDENT;
       this.number = number;
    }

    public int getNumber(){
        return number;
    }
    


    
}
