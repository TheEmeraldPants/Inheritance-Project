import java.util.Scanner;
public class SelectingPeripherals {
    Scanner scanner = new Scanner(System.in);
    //initialize budget, mid-range, gaming, and high-end peripherals
    Keyboard budgetKeyboard = new Keyboard(12.99, "Logitech", false, 1, "K120", "Reliable and durable, equipped with a number pad with an easy-to-use design that works right out of the box.", 19.4, new double[]{0.5, 0.2, 0.1}, "USB", "Rubber Dome", 100, false);
    Keyboard midRangeKeyboard = new Keyboard(34.99, "Logitech", false, 0, "K400 Plus Wireless Touch", "Quiet, easy-to-use keyboard with a built-in touchpad, plus all the hotkeys Windows® and Android™ users know and love.", 13.76, new double[]{5.51, 13.95, 0.93}, "Battery Operated", "Linear", 60, true);
    Keyboard gamingKeyboard = new Keyboard(249.99, "Razer", true, 3, "Huntsman V3 Pro", "Low-profile mechanical gaming keyboard with customizable RGB lighting and programmable keys.", 1.5, new double[]{14.2, 5.4, 0.9}, "USB-C", "Mechanical", 80, true);
    Keyboard highEndKeyboard = new Keyboard(249.99, "Corsair", true, 5, "K100 RGB", "High-end mechanical gaming keyboard with customizable RGB lighting and programmable keys.", 2.5, new double[]{17.5, 6.5, 1.5}, "USB-C", "Corsair OPX", 100, true);

    Mouse budgetMouse = new Mouse(9.99, "Logitech", false, 1, "M100", "Basic wired mouse with a simple design and reliable performance.", 0.2, new double[]{4.5, 2.5, 1}, "USB", 100, 0);
    Mouse midRangeMouse = new Mouse(29.99, "Logitech", false, 0, "M720 Triathlon", "Multi-device wireless mouse with customizable buttons and long battery life.", 0.1, new double[]{4.5, 2.5, 1}, "Bluetooth", 1600, 3);
    Mouse gamingMouse = new Mouse(79.99, "Logitech", true, 2, "G502 HERO", "High-performance gaming mouse with customizable RGB lighting and programmable buttons.", 0.1, new double[]{4.5, 2.5, 1}, "USB", 16000, 11);
    Mouse highEndMouse = new Mouse(149.99, "Razer", true, 3, "Viper Ultimate", "Wireless gaming mouse with customizable RGB lighting and ultra-lightweight design.", 0.1, new double[]{4.5, 2.5, 1}, "USB-C", 20000, 8);

    Monitor budgetMonitor = new Monitor(99.99, "Acer", false, 0, "R240HY", "23.8-inch Full HD IPS monitor with slim bezels and wide viewing angles.", 3.5, new double[]{21.2, 20.5, 1.5}, "HDMI", "1080P", true);
    Monitor midRangeMonitor = new Monitor(249.99, "Dell", false, 0, "UltraSharp U2415", "24-inch WUXGA IPS monitor with ultra-thin bezels and wide color coverage.", 3.5, new double[]{21.2, 20.5, 1.5}, "HDMI", "WUXGA", true);
    Monitor gamingMonitor = new Monitor(499.99, "ASUS", true, 2, "ROG Swift PG259QN", "24.5-inch Full HD gaming monitor with 360Hz refresh rate and G-SYNC support.", 3.5, new double[]{21.2, 20.5, 1.5}, "HDMI", "1080P", true);
    Monitor highEndMonitor = new Monitor(999.99, "LG", true, 5, "UltraGear 38GN950-B", "38-inch UltraWide QHD+ gaming monitor with 144Hz refresh rate and HDR support.", 3.5, new double[]{21.2, 20.5, 1.5}, "HDMI", "UltraWide QHD+", true);

    Headset budgetHeadset = new Headset(29.99, "Logitech", false, 0, "H390", "Wired headset with noise-canceling microphone and in-line volume control.", 0.5, new double[]{7.5, 6.5, 3}, "USB", true, "Balanced");
    Headset midRangeHeadset = new Headset(79.99, "HyperX", false, 1, "Cloud II", "Comfortable wired gaming headset with virtual 7.1 surround sound.", 0.5, new double[]{7.5, 6.5, 3}, "USB", true, "Bass");
    Headset gamingHeadset = new Headset(149.99, "SteelSeries", true, 2, "Arctis Pro Wireless", "High-end wireless gaming headset with dual-battery system and customizable RGB lighting.", 0.5, new double[]{7.5, 6.5, 3}, "USB-C", true, "Bass");
    Headset highEndHeadset = new Headset(299.99, "Razer", true, 3, "Nari Ultimate", "Wireless gaming headset with haptic feedback and customizable RGB lighting.", 0.5, new double[]{7.5, 6.5, 3}, "USB-C", true, "Bass");

    MousePad budgetMousepad = new MousePad(9.99, "SteelSeries", false, 0, "QcK", "Basic cloth mousepad with a non-slip rubber base.", 0.2, new double[]{12, 10, 0.1}, "USB", "Cloth");
    MousePad midRangeMousepad = new MousePad(19.99, "Corsair", false, 0, "MM300", "Extended cloth mousepad with anti-fray stitching and non-slip rubber base.", 0.2, new double[]{12, 10, 0.1}, "USB", "Cloth");
    MousePad gamingMousepad = new MousePad(39.99, "Razer", true, 1, "Firefly V2", "RGB mousepad with customizable lighting and durable surface.", 0.2, new double[]{12, 10, 0.1}, "USB-C", "Plastic");
    MousePad highEndMousepad = new MousePad(79.99, "Corsair", true, 2, "MM800 RGB Polaris", "RGB mousepad with extreme custom lighting and pristine micro textured surface.", 0.2, new double[]{12, 10, 0.1}, "USB-C", "Micro Textured");


    //initialize selected peripherals
    Keyboard selectedKeyboard;
    Mouse selectedMouse;
    Monitor selectedMonitor;
    Headset selectedHeadset;
    MousePad selectedMousepad;

    double totalPrice = 0;
    int totalPowerConsumption = 0;

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
        
    }

}