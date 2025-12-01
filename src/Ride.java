package src;

import java.util.*;
import java.io.*;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;
    
    private Queue<Visitor> waitingQueue;
    private LinkedList<Visitor> rideHistory;
    
    public Ride() {
        this.rideName = "Unknown Ride";
        this.capacity = 10;
        this.operator = null;
        this.maxRider = 5;
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }
    
    public Ride(String rideName, int capacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }
    
    public String getRideName() {
        return rideName;
    }
    
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public Employee getOperator() {
        return operator;
    }
    
    public void setOperator(Employee operator) {
        this.operator = operator;
    }
    
    public int getMaxRider() {
        return maxRider;
    }
    
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }
    
    public int getNumOfCycles() {
        return numOfCycles;
    }
    
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " added to queue for " + rideName);
        } else {
            System.out.println("Error: Cannot add null visitor to queue");
        }
    }
    
    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removed = waitingQueue.poll();
            System.out.println("Visitor " + removed.getName() + " removed from queue");
        } else {
            System.out.println("Queue is empty, cannot remove visitor");
        }
    }
    
    @Override
    public void printQueue() {
        System.out.println("=== Waiting Queue for " + rideName + " ===");
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            int position = 1;
            for (Visitor visitor : waitingQueue) {
                System.out.println(position + ". " + visitor);
                position++;
            }
        }
        System.out.println("Total visitors in queue: " + waitingQueue.size());
    }
    
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null && !rideHistory.contains(visitor)) {
            rideHistory.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " added to ride history");
        } else {
            System.out.println("Cannot add visitor to history (null or already exists)");
        }
    }
    
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor != null) {
            boolean exists = rideHistory.contains(visitor);
            System.out.println("Visitor " + visitor.getName() + 
                (exists ? " is in ride history" : " is not in ride history"));
            return exists;
        }
        return false;
    }
    
    @Override
    public int numberOfVisitors() {
        System.out.println("Number of visitors in history: " + rideHistory.size());
        return rideHistory.size();
    }
    
    @Override
    public void printRideHistory() {
        System.out.println("=== Ride History for " + rideName + " ===");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in history");
        } else {
            Iterator<Visitor> iterator = rideHistory.iterator();
            int count = 1;
            while (iterator.hasNext()) {
                System.out.println(count + ". " + iterator.next());
                count++;
            }
        }
    }
    
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
            System.out.println("Ride history sorted successfully");
        } else {
            System.out.println("Not enough visitors to sort");
        }
    }
    
    @Override
    public void runOneCycle() {
        System.out.println("=== Attempting to run " + rideName + " ===");
        
        if (operator == null || !operator.isOnDuty()) {
            System.out.println("Error: No operator assigned or operator not on duty");
            return;
        }
        
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: No visitors in queue");
            return;
        }
        
        int ridersProcessed = Math.min(maxRider, waitingQueue.size());
        System.out.println("Processing " + ridersProcessed + " visitors for this cycle");
        
        for (int i = 0; i < ridersProcessed; i++) {
            Visitor rider = waitingQueue.poll();
            if (rider != null) {
                addVisitorToHistory(rider);
                System.out.println("Visitor " + rider.getName() + " completed the ride");
            }
        }
        
        numOfCycles++;
        System.out.println("Ride cycle completed. Total cycles: " + numOfCycles);
    }
    
    public void exportRideHistory(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.println(visitor.toString());
            }
            System.out.println("Ride history exported to " + filename + " successfully");
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }
    
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            
            System.out.println("=== Starting to import ride history ===");
            while ((line = reader.readLine()) != null) {
                System.out.println("Imported line: " + line);
                count++;
            }
            
            System.out.println("Successfully imported " + count + " records from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error importing ride history: " + e.getMessage());
        }
    }
    
    public int getQueueSize() {
        return waitingQueue.size();
    }
    
    public void clearHistory() {
        rideHistory.clear();
        System.out.println("Ride history cleared");
    }
}
