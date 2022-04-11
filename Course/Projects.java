package Course;
import java.sql.Date;

public class Projects extends EventsClass{

    private static final String PROJECTS = "Project";

    public Projects(String name, Date date) {
        this.name = name;
        this.date = date;
        this.type = PROJECTS;
    }

}
