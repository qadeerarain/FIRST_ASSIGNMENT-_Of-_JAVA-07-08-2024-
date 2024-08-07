// Define the MobilePhone class
class MobilePhone {
    private String brand;
    private String model;
    private double price;
    private int storageCapacity;

    public MobilePhone(String brand, String model, double price, int storageCapacity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storageCapacity = storageCapacity;
    }

    // Method to display phone details
    public void displayPhoneDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: $" + price + ", Storage Capacity: " + storageCapacity + "GB");
    }

    // Method to compare prices of two phones
    public static void comparePrices(MobilePhone phone1, MobilePhone phone2) {
        if (phone1.price < phone2.price) {
            System.out.println(phone1.brand + " " + phone1.model + " is cheaper than " + phone2.brand + " " + phone2.model);
        } else if (phone1.price > phone2.price) {
            System.out.println(phone1.brand + " " + phone1.model + " is more expensive than " + phone2.brand + " " + phone2.model);
        } else {
            System.out.println(phone1.brand + " " + phone1.model + " and " + phone2.brand + " " + phone2.model + " have the same price.");
        }
    }

    // Method to check if a phone meets specific requirements
    public boolean meetsRequirements(int minStorage) {
        return this.storageCapacity >= minStorage;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }
}

// Main class to demonstrate the functionality
public class MobilePhoneInformation {
    public static void main(String[] args) {
        // Create an array of MobilePhone objects
        MobilePhone[] phones = new MobilePhone[4];
        phones[0] = new MobilePhone("apple", "iPhone 13", 999.99, 128);
        phones[1] = new MobilePhone("Samsung", "Galaxy S21", 767.99, 256);
        phones[2] = new MobilePhone("oppo", "Pixel 6", 522.99, 128);
        phones[3] = new MobilePhone("vivo", "9 Pro", 923.99, 512);

        // Display details of all phones
        System.out.println("Phone details:");
        for (MobilePhone phone : phones) {
            phone.displayPhoneDetails();
        }

        // Compare prices of two phones
        System.out.println("\nComparing prices:");
        MobilePhone.comparePrices(phones[0], phones[1]);

        // Check if a phone meets specific requirements
        int minStorage = 256;
        System.out.println("\nPhones meeting the storage requirement of at least " + minStorage + "GB:");
        for (MobilePhone phone : phones) {
            if (phone.meetsRequirements(minStorage)) {
                phone.displayPhoneDetails();
            }
        }

        // Find the phone with the highest storage capacity
        MobilePhone highestStoragePhone = phones[0];
        for (MobilePhone phone : phones) {
            if (phone.getStorageCapacity() > highestStoragePhone.getStorageCapacity()) {
                highestStoragePhone = phone;
            }
        }
        System.out.println("\nPhone with the highest storage capacity:");
        highestStoragePhone.displayPhoneDetails();
    }
}
