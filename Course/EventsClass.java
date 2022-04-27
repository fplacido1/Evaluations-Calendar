package Course;

import java.time.*;

public abstract class EventsClass implements Events{

    protected String name;
    protected String type;
    protected LocalDate date;

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public LocalDate getDate(){
        return date;
    }
    
    
}