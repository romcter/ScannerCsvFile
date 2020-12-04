import java.util.HashMap;

public class Employee {
    private String employeeName;
    private HashMap<String, String> dateWithHours = new HashMap<>();

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public HashMap<String, String> getDateWithHours() {
        return dateWithHours;
    }

    public void setDateWithHours(HashMap<String, String> dateWithHours) {
        this.dateWithHours = dateWithHours;
    }

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }
}
