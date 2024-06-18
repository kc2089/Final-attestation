import java.util.ArrayList;
import java.util.Scanner;

public class AnimalRegistry {
    private static ArrayList<Animal> animals = new ArrayList<>();
    private static int animalCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAnimal Registry Menu:");
            System.out.println("1. Add new animal");
            System.out.println("2. List animal commands");
            System.out.println("3. Train new commands");
            System.out.println("4. List animals by birth date");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addNewAnimal(scanner);
                    break;
                case 2:
                    listAnimalCommands(scanner);
                    break;
                case 3:
                    trainNewCommands(scanner);
                    break;
                case 4:
                    listAnimalsByBirthDate();
                    break;
                case 5:
                    System.out.println("Exiting the registry.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addNewAnimal(Scanner scanner) {
        System.out.print("Enter animal type (Dog, Cat, Hamster, Horse, Camel, Donkey): ");
        String type = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birth date (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter commands (comma-separated): ");
        String[] commands = scanner.nextLine().split(",");

        Animal animal = null;
        switch (type.toLowerCase()) {
            case "dog":
                animal = new Dog(name, birthDate, commands);
                break;
            case "cat":
                animal = new Cat(name, birthDate, commands);
                break;
            case "hamster":
                animal = new Hamster(name, birthDate, commands);
                break;
            case "horse":
                animal = new Horse(name, birthDate, commands);
                break;
            case "camel":
                animal = new Camel(name, birthDate, commands);
                break;
            case "donkey":
                animal = new Donkey(name, birthDate, commands);
                break;
            default:
                System.out.println("Invalid animal type. Animal not added.");
                return;
        }

        animals.add(animal);
        animalCount++;
        System.out.println(type + " named " + name + " added to the registry.");
    }

    private static void listAnimalCommands(Scanner scanner) {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();

        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println("Commands for " + name + ":");
                for (String command : animal.getCommands()) {
                    System.out.println("- " + command);
                }
                return;
            }
        }

        System.out.println("Animal not found.");
    }

    private static void trainNewCommands(Scanner scanner) {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();

        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new command to train: ");
                String newCommand = scanner.nextLine();
                animal.addCommand(newCommand);
                System.out.println(name + " has been trained to: " + newCommand);
                return;
            }
        }

        System.out.println("Animal not found.");
    }

    private static void listAnimalsByBirthDate() {
        animals.sort((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()));
        System.out.println("Animals sorted by birth date:");
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " (" + animal.getBirthDate() + ")");
        }
    }
}

class Animal {
    protected String name;
    protected String birthDate;
    protected String[] commands;

    public Animal(String name, String birthDate, String[] commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String[] getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        String[] newCommands = new String[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);
        newCommands[commands.length] = command;
        commands = newCommands;
    }
}

class Pet extends Animal {
    public Pet(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class PackAnimal extends Animal {
    public PackAnimal(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Dog extends Pet {
    public Dog(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Cat extends Pet {
    public Cat(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Hamster extends Pet {
    public Hamster(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Horse extends PackAnimal {
    public Horse(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Camel extends PackAnimal {
    public Camel(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}

class Donkey extends PackAnimal {
    public Donkey(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
}
