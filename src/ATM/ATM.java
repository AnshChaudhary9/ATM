package ATM;

public class ATM {
    private int balance;
    private int pin;

    public ATM(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void menu(){
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdrawal(int amount){
        if(balance<=amount){
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
    }

    public int getBalance(){
        return balance;
    }

    public boolean validatePin(int pin){
        return this.pin == pin;
    }

    public void changePin(int newPin){
        this.pin = newPin;
        System.out.println("Pin changed successfully!");
    }

    public static void main(String[] args) {
        ATM atm = new ATM(10000,1234);
        System.out.println("Enter the PIN: ");
        int pin = Integer.parseInt(System.console().readLine());
        if (atm.validatePin(pin)){
            int option = 0;
            while(option!=5){
                atm.menu();
                option = Integer.parseInt(System.console().readLine());
                switch (option){
                    case 1:
                        System.out.println("Balance: "+ atm.getBalance());
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit: ");
                        int amount = Integer.parseInt(System.console().readLine());
                        atm.deposit(amount);
                        break;
                    case 3:
                        System.out.println("Enter amount to withdraw: ");
                        amount = Integer.parseInt(System.console().readLine());
                        atm.withdrawal(amount);
                        break;
                    case 4:
                        System.out.println("Enter new PIN: ");
                        int newPin = Integer.parseInt(System.console().readLine());
                        atm.changePin(newPin);
                        break;
                    case 5:
                        System.out.println("Thank you for using ATM");
                        break;
                    default:
                        System.out.println("Enter a valid option");
                        break;
                }
            }
        }
        else {
            System.out.println("Invalid PIN");
        }
    }
}