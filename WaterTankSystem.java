import javax.swing.*;

// Abstract class
abstract class WaterTank {
    protected int capacity;
    protected int currentLevel;

    public WaterTank(int capacity) {
        this.capacity = capacity;
        this.currentLevel = 0; // tank starts empty
    }

    // abstract methods (subclasses must implement these)
    public abstract void fillTank(int liters);
    public abstract void useWater(int liters);
    public abstract void checkStatus();
}

// HomeTank subclass
class HomeTank extends WaterTank {
    public HomeTank() {
        super(200); // Home tank = 200 liters
    }

    @Override
    public void fillTank(int liters) {
        if (currentLevel + liters > capacity) {
            liters = capacity - currentLevel;
        }
        currentLevel += liters;
        JOptionPane.showMessageDialog(null, 
            "Added " + liters + " liters. Current: " + currentLevel + "/" + capacity);
    }

    @Override
    public void useWater(int liters) {
        if (currentLevel - liters < 0) {
            liters = currentLevel;
        }
        currentLevel -= liters;
        JOptionPane.showMessageDialog(null, 
            "Used " + liters + " liters. Current: " + currentLevel + "/" + capacity);
    }

    @Override
    public void checkStatus() {
    	
        if (currentLevel == 0) {
            JOptionPane.showMessageDialog(null, "Home Tank is Empty.");
        } else if (currentLevel == capacity) {
            JOptionPane.showMessageDialog(null, "Home Tank is Full.");
        } else {
            JOptionPane.showMessageDialog(null, "Home Tank is In Use.");
        }
    }
}

// BuildingTank subclass
class BuildingTank extends WaterTank {
    public BuildingTank() {
        super(1000); // Building tank = 1000 liters
    }

    @Override
    public void fillTank(int liters) {
        if (currentLevel + liters > capacity) {
            liters = capacity - currentLevel;
        }
        currentLevel += liters;
        JOptionPane.showMessageDialog(null, 
            "Added " + liters + " liters. Current: " + currentLevel + "/" + capacity);
    }

    
    @Override
    public void useWater(int liters) {
        if (currentLevel - liters < 0) {
            liters = currentLevel;
        }
        currentLevel -= liters;
        JOptionPane.showMessageDialog(null, 
            "Used " + liters + " liters. Current: " + currentLevel + "/" + capacity);
    }

    @Override
    public void checkStatus() {
        if (currentLevel == 0) {
            JOptionPane.showMessageDialog(null, "Building Tank is Empty.");
        } else if (currentLevel == capacity) {
            JOptionPane.showMessageDialog(null, "Building Tank is Full.");
        } else {
            JOptionPane.showMessageDialog(null, "Building Tank is In Use.");
        }
    }
}

// Main class
public class WaterTankSystem {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog(
            "Choose tank:\n1. Home Tank (200L)\n2. Building Tank (1000L)"
        );

        WaterTank tank;
        if (choice.equals("1")) {
            tank = new HomeTank();
        } else {
            tank = new BuildingTank();
        }

        while (true) {
            String action = JOptionPane.showInputDialog(
                "What do you want to do?\n1. Fill Tank\n2. Use Water\n3. Check Status"
            );

            if (action.equals("1")) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Liters to fill:"));
                tank.fillTank(liters);
            } else if (action.equals("2")) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Liters to use:"));
                tank.useWater(liters);
            } else if (action.equals("3")) {
                tank.checkStatus();
            }

            // program ends if tank is full or empty
            if (tank.currentLevel == 0 || tank.currentLevel == tank.capacity) {
                tank.checkStatus();
                JOptionPane.showMessageDialog(null, "Program ends here.");
                break;
            }
        }
    }
}
