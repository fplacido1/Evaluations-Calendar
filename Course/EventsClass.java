package Course;

import java.sql.Date;

public abstract class EventsClass implements Events{

    protected String name;
    protected String type;
    protected Date date; //ver ppt da stora

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public Date getDate(){
        return date;
    }
    
}