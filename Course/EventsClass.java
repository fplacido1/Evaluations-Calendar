package Course;

import java.time.*;

public abstract class EventsClass implements Events{

    protected String name;
    protected String type;
    protected LocalDate date;

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public LocalDate getDate(){
        return date;
    }
    
    
}