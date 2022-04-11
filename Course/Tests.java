package Course;

import java.sql.*;

public class Tests extends EventsClass{

    private static final String TESTS = "Tests";

    private Time hour;//ver ppt professora

    public Tests(String name, Date date, Time hour){
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.type = TESTS;
    }

    public Time getHour(){//ver ppt prof
        return hour;
    }
    
}
