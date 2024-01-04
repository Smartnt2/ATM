public class Customer {
    private String name;
    private int pin;

    public Customer(String name, int pin) {
        this.name = name;
        this.pin = pin;
    }

    public void setPin(int newPin) {
        pin = newPin;
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public boolean checkPin(int toCheck) {
        return pin == toCheck;
    }
}
