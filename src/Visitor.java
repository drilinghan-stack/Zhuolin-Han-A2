package src;
public class Visitor extends Person {
    private String ticketType;
    private boolean hasFastPass;
    private int visitCount;
    
    public Visitor() {
        super();
        this.ticketType = "Standard";
        this.hasFastPass = false;
        this.visitCount = 0;
    }
    
    public Visitor(String name, int age, String id, 
                  String ticketType, boolean hasFastPass, int visitCount) {
        super(name, age, id);
        this.ticketType = ticketType;
        this.hasFastPass = hasFastPass;
        this.visitCount = visitCount;
    }
    
    public String getTicketType() {
        return ticketType;
    }
    
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    
    public boolean hasFastPass() {
        return hasFastPass;
    }
    
    public void setHasFastPass(boolean hasFastPass) {
        this.hasFastPass = hasFastPass;
    }
    
    public int getVisitCount() {
        return visitCount;
    }
    
    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
    
    public void incrementVisitCount() {
        this.visitCount++;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Ticket Type: " + ticketType + 
               ", Fast Pass: " + (hasFastPass ? "Yes" : "No") + 
               ", Visit Count: " + visitCount;
    }
}