import java.util.HashMap;

public class Employee {
    private HashMap<String, String> dateWithHours = new HashMap<>();

    public HashMap<String, String> getDateWithHours() {
        return dateWithHours;
    }

    public void setDateWithHours(HashMap<String, String> dateWithHours) {
        this.dateWithHours = dateWithHours;
    }

}
