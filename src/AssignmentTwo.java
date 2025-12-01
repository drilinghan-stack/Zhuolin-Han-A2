package src;

public class AssignmentTwo {
    
    public static void main(String[] args) {
        System.out.println("=== Theme Park Management System Demonstration ===");
        System.out.println("PROG2004 - Assessment 2 - Portfolio Project\n");
        
        AssignmentTwo a2 = new AssignmentTwo();
        
        System.out.println("Starting Part 3: Waiting Queue Management...");
        a2.partThree();
        
        System.out.println("\nStarting Part 4A: Ride History Management...");
        a2.partFourA();
        
        System.out.println("\nStarting Part 4B: Ride History Sorting...");
        a2.partFourB();
        
        System.out.println("\nStarting Part 5: Ride Cycle Operation...");
        a2.partFive();
        
        System.out.println("\nStarting Part 6: File Writing...");
        a2.partSix();
        
        System.out.println("\nStarting Part 7: File Reading...");
        a2.partSeven();
        
        System.out.println("\n=== All Demonstrations Completed ===");
    }
    
    public void partThree() {
        System.out.println("=== Part 3: Waiting Queue Demonstration ===");
        
        Employee operator = new Employee("John Doe", 25, "E001", 
                                         "Operations", "OP001", true);
        Ride rollerCoaster = new Ride("Roller Coaster", 20, operator, 5);
        
        System.out.println("Created ride: " + rollerCoaster.getRideName());
        
        System.out.println("\nAdding 5 visitors to queue:");
        for (int i = 1; i <= 5; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, "V00" + i, 
                                          "Standard", false, 1);
            rollerCoaster.addVisitorToQueue(visitor);
        }
        
        System.out.println("\nPrinting current queue:");
        rollerCoaster.printQueue();
        
        System.out.println("\nRemoving one visitor from queue:");
        rollerCoaster.removeVisitorFromQueue();
        
        System.out.println("\nQueue after removal:");
        rollerCoaster.printQueue();
    }
    
    public void partFourA() {
        System.out.println("=== Part 4A: Ride History Demonstration ===");
        
        Ride ferrisWheel = new Ride("Ferris Wheel", 15, null, 4);
        System.out.println("Created ride: " + ferrisWheel.getRideName());
        
        System.out.println("\nAdding 5 visitors to history:");
        for (int i = 1; i <= 5; i++) {
            Visitor visitor = new Visitor("HistoryVisitor" + i, 15 + i, "H00" + i, 
                                          "Premium", i % 2 == 0, i);
            ferrisWheel.addVisitorToHistory(visitor);
        }
        
        Visitor testVisitor = new Visitor("HistoryVisitor3", 18, "H003", 
                                          "Premium", false, 3);
        System.out.println("\nChecking if visitor is in history:");
        ferrisWheel.checkVisitorFromHistory(testVisitor);
        
        System.out.println("\nGetting number of visitors in history:");
        ferrisWheel.numberOfVisitors();
        
        System.out.println("\nPrinting ride history (using iterator):");
        ferrisWheel.printRideHistory();
    }
    
    public void partFourB() {
        System.out.println("=== Part 4B: Ride History Sorting Demonstration ===");
        
        Ride waterRide = new Ride("Water Slide", 8, null, 3);
        System.out.println("Created ride: " + waterRide.getRideName());
        
        Visitor[] visitors = {
            new Visitor("Zoe", 25, "V101", "Standard", true, 2),
            new Visitor("Alice", 30, "V102", "Premium", false, 1),
            new Visitor("Bob", 22, "V103", "Standard", true, 3),
            new Visitor("Charlie", 28, "V104", "Premium", true, 2),
            new Visitor("David", 22, "V105", "Standard", false, 1)
        };
        
        System.out.println("\nAdding 5 visitors to history:");
        for (Visitor visitor : visitors) {
            waterRide.addVisitorToHistory(visitor);
        }
        
        System.out.println("\nHistory before sorting:");
        waterRide.printRideHistory();
        
        System.out.println("\nCreating comparator and sorting (by age and name):");
        VisitorComparator comparator = new VisitorComparator();
        waterRide.sortRideHistory(comparator);
        
        System.out.println("\nHistory after sorting:");
        waterRide.printRideHistory();
    }
    
    public void partFive() {
        System.out.println("=== Part 5: Ride Cycle Operation Demonstration ===");
        
        Employee operator = new Employee("Sarah Smith", 28, "E002", 
                                         "Operations", "OP002", true);
        
        Ride hauntedHouse = new Ride("Haunted House", 6, operator, 3);
        System.out.println("Created ride: " + hauntedHouse.getRideName());
        
        System.out.println("\nAdding 10 visitors to queue:");
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("QueueVisitor" + i, 18 + i, "Q00" + i, 
                                          "Standard", i > 5, 1);
            hauntedHouse.addVisitorToQueue(visitor);
        }
        
        System.out.println("\nInitial queue:");
        hauntedHouse.printQueue();
        
        System.out.println("\nRunning one ride cycle:");
        hauntedHouse.runOneCycle();
        
        System.out.println("\nQueue after one cycle:");
        hauntedHouse.printQueue();
        
        System.out.println("\nHistory after cycle:");
        hauntedHouse.printRideHistory();
    }
    
    public void partSix() {
        System.out.println("=== Part 6: File Writing Demonstration ===");
        
        Ride logRide = new Ride("Log Ride", 10, null, 4);
        System.out.println("Created ride: " + logRide.getRideName());
        
        System.out.println("\nAdding 5 visitors to history:");
        for (int i = 1; i <= 5; i++) {
            Visitor visitor = new Visitor("FileVisitor" + i, 20 + i, "F00" + i, 
                                          "Standard", false, i);
            logRide.addVisitorToHistory(visitor);
        }
        
        System.out.println("\nExporting ride history to file:");
        logRide.exportRideHistory("ride_history.txt");
    }
    
    public void partSeven() {
        System.out.println("=== Part 7: File Reading Demonstration ===");
        
        Ride newRide = new Ride("New Ride", 12, null, 4);
        System.out.println("Created ride: " + newRide.getRideName());
        
        System.out.println("\nImporting ride history from file:");
        newRide.importRideHistory("ride_history.txt");
        
        System.out.println("\nNote: Need to implement file parsing to create Visitor objects");
    }
}