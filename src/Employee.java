package src;
public class Employee extends Person {
    private String department;
    private String employeeId;
    private boolean isOnDuty;
    
    public Employee() {
        super();
        this.department = "Operations";
        this.employeeId = "EMP000";
        this.isOnDuty = false;
    }
    
    public Employee(String name, int age, String id, 
                   String department, String employeeId, boolean isOnDuty) {
        super(name, age, id);
        this.department = department;
        this.employeeId = employeeId;
        this.isOnDuty = isOnDuty;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public boolean isOnDuty() {
        return isOnDuty;
    }
    
    public void setOnDuty(boolean onDuty) {
        isOnDuty = onDuty;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Department: " + department + 
               ", Employee ID: " + employeeId + 
               ", On Duty: " + (isOnDuty ? "Yes" : "No");
    }
}