import java.util.Scanner;
abstract class Account
{
    double interestRate;
    double amount;
    abstract double calculateInterest();
}
class FDAccount extends Account
{
    int noOfDays;
    int ageOfACHolder;
    FDAccount(double amount, int noOfDays, int ageOfACHolder)
    {
        if (amount <= 0 | noOfDays <= 0 | ageOfACHolder < 0) {
        throw new IllegalArgumentException("Invalid input values.");
    }
        this.amount = amount;
        this.noOfDays =noOfDays;
        this.ageOfACHolder = ageOfACHolder;
    }
    double calculateInterest() {
        if (amount < 1_00_00_000) {
            if (noOfDays >= 7 &&noOfDays <= 14)
            { interestRate = ageOfACHolder >= 60 ? 5.0 : 4.5;
            } else if (noOfDays >= 15 && noOfDays <= 29)
            { interestRate = ageOfACHolder >= 60 ? 5.25 : 4.75;
            } else if (noOfDays >= 30 && noOfDays <= 45)
            { interestRate = ageOfACHolder >= 60 ? 6.0 : 5.5;
            } else if (noOfDays >= 45 && noOfDays <= 60)
            { interestRate = ageOfACHolder >= 60 ? 7.5 : 7.0;
            } else if (noOfDays >= 61 &&noOfDays <= 184)
            { interestRate = ageOfACHolder >= 60 ? 8.0 : 7.5;
            } else if (noOfDays >= 185 &&noOfDays <= 365)
            { interestRate = ageOfACHolder >= 60 ? 8.5 : 8.0;

            }
            else {
                throw new IllegalArgumentException("Invalid number of days.");
            }
        }
        else {
            if (noOfDays >= 7 && noOfDays <=14)
            { interestRate = 6.5;
            } else if (noOfDays >= 15 && noOfDays <= 29)
            { interestRate = 6.75;
            } else if (noOfDays >= 30 && noOfDays <= 45)
            { interestRate = 6.75;
            } else if (noOfDays >= 45 && noOfDays <= 60)
            { interestRate = 8.0;
            } else if (noOfDays >= 61 && noOfDays <= 184)
            { interestRate = 8.5;
            } else if (noOfDays >= 185 &&noOfDays <= 365)
            { interestRate = 10.0;
            }
            else {
                throw new IllegalArgumentException("Invalid number of days.");
            }
        }
        return (amount * interestRate) / 100;
    }
}
class SBAccount extends Account
{
    String accountType;
    SBAccount(double amount, String accountType) {
        if (amount <= 0 | (!accountType.equalsIgnoreCase("Normal") &&
                !accountType.equalsIgnoreCase("NRI"))) {
            throw new IllegalArgumentException("Invalid input values.");
        }
        this.amount = amount;
        this.accountType = accountType;
    }
    double calculateInterest() {
        if (accountType.equalsIgnoreCase("Normal")) {
            interestRate = 4.0;
        }
        else if (accountType.equalsIgnoreCase("NRI")) {
            interestRate = 6.0;
        }
        else {
            throw new IllegalArgumentException("Invalid account type.");
        }
        return (amount * interestRate) / 100;
    }
}
class RDAccount extends Account
{
    int noOfMonths;
    double monthlyAmount;
    int ageOfACHolder;
    RDAccount(double monthlyAmount, int noOfMonths, int ageOfACHolder) {
        if (monthlyAmount <= 0 | noOfMonths <= 0 | ageOfACHolder < 0) {
             throw new IllegalArgumentException("Invalid input values.");
        }
    this.monthlyAmount = monthlyAmount;
    this.noOfMonths = noOfMonths;
    this.ageOfACHolder = ageOfACHolder;
    }
    double calculateInterest() {
        if (noOfMonths == 6) {
        interestRate = ageOfACHolder >= 60 ? 8.0 : 7.5;
    }
        else if (noOfMonths == 9) {
        interestRate = ageOfACHolder >= 60 ? 8.25 : 7.75;
    }
        else if (noOfMonths == 12) {
        interestRate = ageOfACHolder >= 60 ? 8.5 : 8.0;
    }
        else if (noOfMonths == 15) {
        interestRate = ageOfACHolder >= 60 ? 8.75 : 8.25;



    }
        else if (noOfMonths == 18) {
        interestRate = ageOfACHolder >= 60 ? 9.0 : 8.5;
    }
        else if (noOfMonths == 21) {
        interestRate = ageOfACHolder >= 60 ? 9.25 : 8.75;
    }
        else {
        throw new IllegalArgumentException("Invalid number of months.");
    }
        double totalAmount = monthlyAmount * noOfMonths;
        return (totalAmount * interestRate) / 100;
    }
}
public class Experiment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect the option:");
            System.out.println("1. Interest Calculator– SB");
            System.out.println("2. Interest Calculator– FD");
            System.out.println("3. Interest Calculator– RD");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter the average amount in your account: ");
                        double sbAmount = scanner.nextDouble();
                        System.out.print("Enter account type (Normal/NRI): ");
                        String accountType = scanner.next();
                        SBAccount sbAccount = new SBAccount(sbAmount, accountType);
                        System.out.println("Interest gained: Rs. " + sbAccount.calculateInterest());
                        break;
                    case 2:
                        System.out.print("Enter the FD amount: ");
                        double fdAmount = scanner.nextDouble();
                        System.out.print("Enter the number of days: ");
                        int fdDays = scanner.nextInt();
                        System.out.print("Enter your age: ");
                        int fdAge = scanner.nextInt();
                        FDAccount fdAccount = new FDAccount(fdAmount, fdDays, fdAge);
                        System.out.println("Interest gained is: Rs. " + fdAccount.calculateInterest());
                        break;
                    case 3:
                        System.out.print("Enter the monthly amount: ");
                        double rdAmount = scanner.nextDouble();
                        System.out.print("Enter the number of months: ");
                        int rdMonths = scanner.nextInt();
                        System.out.print("Enter your age: ");
                        int rdAge = scanner.nextInt();
                        RDAccount rdAccount = new RDAccount(rdAmount, rdMonths, rdAge);
                        System.out.println("Interest gained: Rs. " + rdAccount.calculateInterest());
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
