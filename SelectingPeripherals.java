import java.util.Scanner;
public class SelectingPeripherals {
    Scanner scanner = new Scanner(System.in);
    //initialize budget, mid-range, gaming, and high-end peripherals
    Keyboard budgetKeyboard = new Keyboard(50, "Logitech", false, 5, "A budget keyboard with basic features.", 0.5, new double[]{40, 15, 5}, "USB", "Membrane", 100, false);
    Keyboard midRangeKeyboard = new Keyboard(100, "Corsair", true, 8, "A mid-range keyboard with customizable RGB lighting.", 0.8, new double[]{45, 20, 5}, "USB", "Mechanical", 80, true);
    Keyboard gamingKeyboard = new Keyboard(150, "Razer", true, 10, "A high-end gaming keyboard with RGB lighting.", 1.0, new double[]{45, 20, 5}, "USB", "Mechanical", 100, true);
    Keyboard highEndKeyboard = new Keyboard(200, "SteelSeries", true, 12, "A high-end keyboard with customizable RGB lighting.", 1.2, new double[]{50, 25, 5}, "USB", "Mechanical", 100, true);

    Mouse budgetMouse = new Mouse(30, "Logitech", false, 3, "A budget mouse with basic features.", 0.2, new double[]{10, 5, 4}, "USB", 8000, 0);
    Mouse midRangeMouse = new Mouse(60, "Corsair", true, 5, "A mid-range mouse with customizable RGB lighting.", 0.3, new double[]{12, 6, 4}, "USB", 16000, 3);
    Mouse gamingMouse = new Mouse(100, "Razer", true, 7, "A high-end gaming mouse with RGB lighting.", 0.4, new double[]{12, 6, 4}, "USB", 20000, 5);
    Mouse highEndMouse = new Mouse(150, "SteelSeries", true, 10, "A high-end mouse with customizable RGB lighting.", 0.5, new double[]{12, 6, 4}, "USB", 20000, 7);

    Monitor budgetMonitor = new Monitor(150, "Acer", false, 20, "A budget monitor with basic features.", 3.0, new double[]{50, 30, 5}, "HDMI", "1080p", false);
    Monitor midRangeMonitor = new Monitor(300, "Dell", true, 30, "A mid-range monitor with customizable RGB lighting.", 4.0, new double[]{55, 35, 5}, "HDMI", "1440p", true);
    Monitor gamingMonitor = new Monitor(500, "Asus", true, 50, "A high-end gaming monitor with RGB lighting.", 5.0, new double[]{60, 40, 5}, "HDMI", "4K", true);
    Monitor highEndMonitor = new Monitor(800, "Samsung", true, 70, "A high-end monitor with customizable RGB lighting.", 6.0, new double[]{65, 45, 5}, "HDMI", "8K", true);

    Headset budgetHeadset = new Headset(50, "Logitech", false, 5, "A budget headset with basic features.", 0.5, new double[]{20, 15, 10}, "3.5mm", false, "V Shaped");
    Headset midRangeHeadset = new Headset(100, "Corsair", true, 8, "A mid-range headset with customizable RGB lighting.", 0.8, new double[]{25, 20, 10}, "USB", false, "Balanced");
    Headset gamingHeadset = new Headset(150, "Razer", true, 10, "A high-end gaming headset with RGB lighting.", 1.0, new double[]{25, 20, 10}, "USB", true, "Bass Boost");
    Headset highEndHeadset = new Headset(200, "SteelSeries", true, 12, "A high-end headset with customizable RGB lighting.", 1.2, new double[]{30, 25, 10}, "USB", true, "Studio");

    MousePad budgetMousepad = new MousePad(20, "Logitech", false, 2, "A budget mousepad with basic features.", 0.3, new double[]{30, 25, 0.1}, "USB", "Cloth");
    MousePad midRangeMousepad = new MousePad(40, "Corsair", true, 4, "A mid-range mousepad with customizable RGB lighting.", 0.5, new double[]{35, 30, 0.1}, "USB", "Hard");
    MousePad gamingMousepad = new MousePad(60, "Razer", true, 6, "A high-end gaming mousepad with RGB lighting.", 0.7, new double[]{40, 35, 0.1}, "USB", "Full Desk");
    MousePad highEndMousepad = new MousePad(80, "SteelSeries", true, 8, "A high-end mousepad with customizable RGB lighting.", 0.9, new double[]{45, 40, 0.1}, "USB", "Ergonomic");

    //initialize selected peripherals
    Keyboard selectedKeyboard;
    Mouse selectedMouse;
    Monitor selectedMonitor;
    Headset selectedHeadset;
    MousePad selectedMousepad;

    public static void main(String[] args) {
        new SelectingPeripherals().suggestPeripherals();
    }


    public void suggestPeripherals() {
        System.out.println("What kind of peripherals are you looking for?");
        System.out.println("1. Budget");
        System.out.println("2. Mid-range");
        System.out.println("3. Gaming");
        System.out.println("4. High-end");
        System.out.print("Please enter your choice (1-4): ");
        boolean isValid = false;
        int choice = -1;
        while (!isValid) {  
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    isValid = true;
                } else {
                    System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
                }
            } else {
                System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                scanner.next(); // clear the invalid input
            }
        }
        switch (choice) {
            case 1:
                selectedKeyboard = budgetKeyboard;
                selectedMouse = budgetMouse;
                selectedMonitor = budgetMonitor;
                selectedHeadset = budgetHeadset;
                selectedMousepad = budgetMousepad;
                break;
            case 2:
                selectedKeyboard = midRangeKeyboard;
                selectedMouse = midRangeMouse;
                selectedMonitor = midRangeMonitor;
                selectedHeadset = midRangeHeadset;
                selectedMousepad = midRangeMousepad;
                break;
            case 3:
                selectedKeyboard = gamingKeyboard;
                selectedMouse = gamingMouse;
                selectedMonitor = gamingMonitor;
                selectedHeadset = gamingHeadset;
                selectedMousepad = gamingMousepad;
                break;
            case 4:
                selectedKeyboard = highEndKeyboard;
                selectedMouse = highEndMouse;
                selectedMonitor = highEndMonitor;
                selectedHeadset = highEndHeadset;
                selectedMousepad = highEndMousepad;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        System.out.println("You have selected the following peripherals:");
        System.out.println("Keyboard: " + selectedKeyboard.getBrand() + " - $" + selectedKeyboard.getPrice());
        System.out.println("Mouse: " + selectedMouse.getBrand() + " - $" + selectedMouse.getPrice());
        System.out.println("Monitor: " + selectedMonitor.getBrand() + " - $" + selectedMonitor.getPrice());
        System.out.println("Headset: " + selectedHeadset.getBrand() + " - $" + selectedHeadset.getPrice());
        System.out.println("Mousepad: " + selectedMousepad.getBrand() + " - $" + selectedMousepad.getPrice());
        System.out.println("Total Power Consumption: " + (selectedKeyboard.getPowerConsumption() + selectedMouse.getPowerConsumption() + selectedMonitor.getPowerConsumption() + selectedHeadset.getPowerConsumption() + selectedMousepad.getPowerConsumption()) + "W");
        System.out.println("Total Price: " + ("$" + (selectedKeyboard.getPrice() + selectedMouse.getPrice() + selectedMonitor.getPrice() + selectedHeadset.getPrice() + selectedMousepad.getPrice())));
        System.out.println("Are you satisfied with your selection? (yes/no)");
        String satisfaction = scanner.next();
        boolean isSatisfied = false;
        while (!isSatisfied) {
        if (satisfaction.equalsIgnoreCase("yes") || satisfaction.equalsIgnoreCase("y") || satisfaction.equalsIgnoreCase("sure") || satisfaction.equalsIgnoreCase("absolutely") || satisfaction.equalsIgnoreCase("definitely") || satisfaction.equalsIgnoreCase("of course")) {
            System.out.println("Great! Enjoy your new peripherals.");
            isSatisfied = true;
        } else if (satisfaction.equalsIgnoreCase("no") || satisfaction.equalsIgnoreCase("n") || satisfaction.equalsIgnoreCase("not really") || satisfaction.equalsIgnoreCase("nope") || satisfaction.equalsIgnoreCase("not at all")) {
            isSatisfied = true;
            suggestPeripherals();
        }
        else {
            System.out.println("Invalid response. Please answer with 'yes' or 'no'.");
            satisfaction = scanner.next();
        }
    }
    }

    //method for user to select peripherals
    public void selectPeripherals() {
        boolean selecting = true;
        while (selecting) {
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Please select a peripheral:");
                System.out.println("1. Keyboard");
                System.out.println("2. Mouse");
                System.out.println("3. Monitor");
                System.out.println("4. Headset");
                System.out.println("5. Mousepad");
                System.out.print("Please enter your choice (1-5): ");
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 5) {
                        validInput = true;
                        switch (choice) {
                            case 1:
                                boolean validKeyboard = false;
                                while (!validKeyboard) {
                                    System.out.println("Please select a keyboard:");
                                    System.out.println("1: " + budgetKeyboard.getBrand() + " Keyboard- $" + budgetKeyboard.getPrice());
                                    System.out.println("2: " + midRangeKeyboard.getBrand() + " Keyboard- $" + midRangeKeyboard.getPrice());
                                    System.out.println("3: " + gamingKeyboard.getBrand() + " Keyboard- $" + gamingKeyboard.getPrice());
                                    System.out.println("4: " + highEndKeyboard.getBrand() + " Keyboard- $" + highEndKeyboard.getPrice());
                                    System.out.print("Please enter your choice (1-4): ");
                                    if (scanner.hasNextInt()) {
                                        int keyboardChoice = scanner.nextInt();
                                        if (keyboardChoice >= 1 && keyboardChoice <= 4) {
                                            validKeyboard = true;
                                            switch (keyboardChoice) {
                                                case 1:
                                                    selectedKeyboard = budgetKeyboard;
                                                    break;
                                                case 2:
                                                    selectedKeyboard = midRangeKeyboard;
                                                    break;
                                                case 3:
                                                    selectedKeyboard = gamingKeyboard;
                                                    break;
                                                case 4:
                                                    selectedKeyboard = highEndKeyboard;
                                                    break;
                                            }
                                        } else {
                                            System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
                                        }
                                    } else {
                                        System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                                        scanner.next(); // clear the invalid input
                                    }
                                }
                                break;
                            case 2:
                                boolean validMouse = false;
                                while (!validMouse) {
                                    System.out.println("Please select a mouse:");
                                    System.out.println("1: " + budgetMouse.getBrand() + " Mouse- $" + budgetMouse.getPrice());
                                    System.out.println("2: " + midRangeMouse.getBrand() + " Mouse- $" + midRangeMouse.getPrice());
                                    System.out.println("3: " + gamingMouse.getBrand() + " Mouse- $" + gamingMouse.getPrice());
                                    System.out.println("4: " + highEndMouse.getBrand() + " Mouse- $" + highEndMouse.getPrice());
                                    System.out.print("Please enter your choice (1-4): ");
                                    if (scanner.hasNextInt()) {
                                        int mouseChoice = scanner.nextInt();
                                        if (mouseChoice >= 1 && mouseChoice <= 4) {
                                            validMouse = true;
                                            switch (mouseChoice) {
                                                case 1:
                                                    selectedMouse = budgetMouse;
                                                    break;
                                                case 2:
                                                    selectedMouse = midRangeMouse;
                                                    break;
                                                case 3:
                                                    selectedMouse = gamingMouse;
                                                    break;
                                                case 4:
                                                    selectedMouse = highEndMouse;
                                                    break;
                                            }
                                        } else {
                                            System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
                                        }
                                    } else {
                                        System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                                        scanner.next(); // clear the invalid input
                                    }
                                }
                                break;
                            case 3:
                                boolean validMonitor = false;
                                while (!validMonitor) {
                                    System.out.println("Please select a monitor:");
                                    System.out.println("1: " + budgetMonitor.getBrand() + " Monitor- $" + budgetMonitor.getPrice());
                                    System.out.println("2: " + midRangeMonitor.getBrand() + " Monitor- $" + midRangeMonitor.getPrice());
                                    System.out.println("3: " + gamingMonitor.getBrand() + " Monitor- $" + gamingMonitor.getPrice());
                                    System.out.println("4: " + highEndMonitor.getBrand() + " Monitor- $" + highEndMonitor.getPrice());
                                    System.out.print("Please enter your choice (1-4): ");
                                    if (scanner.hasNextInt()) {
                                        int monitorChoice = scanner.nextInt();
                                        if (monitorChoice >= 1 && monitorChoice <= 4) {
                                            validMonitor = true;
                                            switch (monitorChoice) {
                                                case 1:
                                                    selectedMonitor = budgetMonitor;
                                                    break;
                                                case 2:
                                                    selectedMonitor = midRangeMonitor;
                                                    break;
                                                case 3:
                                                    selectedMonitor = gamingMonitor;
                                                    break;
                                                case 4:
                                                    selectedMonitor = highEndMonitor;
                                                    break;
                                            }
                                        } else {
                                            System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
                                        }
                                    } else {
                                        System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                                        scanner.next(); // clear the invalid input
                                    }
                                }
                                break;
                            case 4:
                                boolean validHeadset = false;
                                while (!validHeadset) {
                                    System.out.println("Please select a headset:");
                                    System.out.println("1: " + budgetHeadset.getBrand() + " Headset- $" + budgetHeadset.getPrice());
                                    System.out.println("2: " + midRangeHeadset.getBrand() + " Headset- $" + midRangeHeadset.getPrice());
                                    System.out.println("3: " + gamingHeadset.getBrand() + " Headset- $" + gamingHeadset.getPrice());
                                    System.out.println("4: " + highEndHeadset.getBrand() + " Headset- $" + highEndHeadset.getPrice());
                                    System.out.print("Please enter your choice (1-4): ");
                                    if (scanner.hasNextInt()) {
                                        int headsetChoice = scanner.nextInt();
                                        if (headsetChoice >= 1 && headsetChoice <= 4) {
                                            validHeadset = true;
                                            switch (headsetChoice) {
                                                case 1:
                                                    selectedHeadset = budgetHeadset;
                                                    break;
                                                case 2:
                                                    selectedHeadset = midRangeHeadset;
                                                    break;
                                                case 3:
                                                    selectedHeadset = gamingHeadset;
                                                    break;
                                                case 4:
                                                    selectedHeadset = highEndHeadset;
                                                    break;
                                            }
                                        } else {
                                            System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
                                        }
                                    } else {
                                        System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                                        scanner.next(); // clear the invalid input
                                    }
                                }
                                break;
                            case 5:
                                boolean validMousepad = false;
                                while (!validMousepad) {
                                    System.out.println("Please select a mousepad:");
                                    System.out.println("1: " + budgetMousepad.getBrand() + " Mousepad- $" + budgetMousepad.getPrice());
                                    System.out.println("2: " + midRangeMousepad.getBrand() + " Mousepad- $" + midRangeMousepad.getPrice());
                                    System.out.println("3: " + gamingMousepad.getBrand() + " Mousepad- $" + gamingMousepad.getPrice());
                                    System.out.println("4: " + highEndMousepad.getBrand() + " Mousepad- $" + highEndMousepad.getPrice());
                                    System.out.print("Please enter your choice (1-4): ");
                                    if (scanner.hasNextInt()) {
                                        int mousepadChoice = scanner.nextInt();
                                        if (mousepadChoice >= 1 && mousepadChoice <= 4) {
                                            validMousepad = true;
                                            switch (mousepadChoice) {
                                                case 1:
                                                    selectedMousepad = budgetMousepad;
                                                    break;
                                                case 2:
                                                    selectedMousepad = midRangeMousepad;
                                                    break;
                                                case 3:
                                                    selectedMousepad = gamingMousepad;
                                                    break;
                                                case 4:
                                                    selectedMousepad = highEndMousepad;
                                                    break;
                                            }
                                        } else {
                                            System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
                                        }
                                    } else {
                                        System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                                        scanner.next(); // clear the invalid input
                                    }
                                }
                                break;
                        }
                    } else {
                        System.out.print("Invalid choice. Please enter a number between 1 and 5: ");
                    }
                } else {
                    System.out.print("Invalid input. Please enter a number between 1 and 5: ");
                    scanner.next(); // clear the invalid input
                }

            }
            System.out.println("Would you like to select another peripheral? (yes/no)");
            String anotherPeripheral = scanner.next();
            if (anotherPeripheral.equalsIgnoreCase("no") || anotherPeripheral.equalsIgnoreCase("n")) {
                selecting = false;
            } else if (anotherPeripheral.equalsIgnoreCase("yes") || anotherPeripheral.equalsIgnoreCase("y")) {
                selecting = true;
            } else {
                System.out.println("Invalid response. Please answer with 'yes' or 'no'.");
            }

        }
        System.out.println("You have selected the following peripherals:");
        int totalPowerConsumption = 0;
        double totalPrice = 0;
        if (selectedKeyboard != null) {
            totalPowerConsumption += selectedKeyboard.getPowerConsumption();
            totalPrice += selectedKeyboard.getPrice();
            System.out.println("Keyboard: " + selectedKeyboard.getBrand() + " - $" + selectedKeyboard.getPrice());
        }
        if (selectedMouse != null) {
            totalPowerConsumption += selectedMouse.getPowerConsumption();
            totalPrice += selectedMouse.getPrice();
            System.out.println("Mouse: " + selectedMouse.getBrand() + " - $" + selectedMouse.getPrice());
        }
        if (selectedMonitor != null) {
            totalPowerConsumption += selectedMonitor.getPowerConsumption();
            totalPrice += selectedMonitor.getPrice();
            System.out.println("Monitor: " + selectedMonitor.getBrand() + " - $" + selectedMonitor.getPrice());
        }
        if (selectedHeadset != null) {
            totalPowerConsumption += selectedHeadset.getPowerConsumption();
            totalPrice += selectedHeadset.getPrice();
            System.out.println("Headset: " + selectedHeadset.getBrand() + " - $" + selectedHeadset.getPrice());
        }
        if (selectedMousepad != null) {
            totalPowerConsumption += selectedMousepad.getPowerConsumption();
            totalPrice += selectedMousepad.getPrice();
            System.out.println("Mousepad: " + selectedMousepad.getBrand() + " - $" + selectedMousepad.getPrice());
        }
        System.out.println("Total Power Consumption: " + totalPowerConsumption + "W");
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Are you satisfied with your selection? (yes/no)");
        String satisfaction = scanner.next();
        boolean isSatisfied = false;
        while (!isSatisfied) {
            if (satisfaction.equalsIgnoreCase("yes") || satisfaction.equalsIgnoreCase("y") || satisfaction.equalsIgnoreCase("sure") || satisfaction.equalsIgnoreCase("absolutely") || satisfaction.equalsIgnoreCase("definitely") || satisfaction.equalsIgnoreCase("of course")) {
                System.out.println("Great! Enjoy your new peripherals.");
                isSatisfied = true;
            } else if (satisfaction.equalsIgnoreCase("no") || satisfaction.equalsIgnoreCase("n") || satisfaction.equalsIgnoreCase("not really") || satisfaction.equalsIgnoreCase("nope") || satisfaction.equalsIgnoreCase("not at all")) {
                isSatisfied = true;
                selectPeripherals();
            } else {
                System.out.println("Invalid response. Please answer with 'yes' or 'no'.");
                satisfaction = scanner.next();
            }
        }
        scanner.close();
        System.out.println("Enjoy your new peripherals!");
        
    }

}