package Course;

import Array.*;
import Peoples.*;

public class CourseClass implements Course{

    private String name;
    Array<People> participants;


    public CourseClass(String name) {
        this.name = name;
    }

    @Override
    public void addStudents(People e) {
       participants.insertLast(e);
    }

    @Override
    public void addTeacher(People e) {
        participants.insertLast(e);
    }

    @Override
    public String getName() {
       return name;
    }

    @Override
    public Iterator<People> peopleIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Events> testsIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addTest(Object e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean eqauls(Object e) {
        if(this == e)
            return true;
            
        CourseClass tmp =(CourseClass) e;
        return tmp.getName().equals(name);
    }
    
}