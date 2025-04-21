import java.util.Scanner;
class Transaction{
    String type;
    double amount;
    public Transaction(String type,double amount){
        this.type = type;
        this.amount = amount;
       
    }
}
public class Tracker{
    public static double balance=0;
    static Transaction[] history = new Transaction[100];
    static int historyCount=0;
    
 
    static void addIncome (double amount){
        if (amount > 0) {
            balance += amount;
            history[historyCount++] = new Transaction("Income", amount);
            System.out.println("Income added successfully!");
        } else {
            System.out.println("Invalid amount!");
        }

    }
    static void  addExpense(double amount){
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                history[historyCount++] = new Transaction("Expense", amount);
                System.out.println("Expense added successfully!");
            } else {
                System.out.println("Not enough balance!");
            }
        } else {
            System.out.println("Invalid amount!");
        }
    }
    public static void printHistory() {
        System.out.println("\n--- Transaction History ---");
        if (historyCount == 0) {
            System.out.println("No transactions yet.");
        } 
        else {
            for (int i = 0; i < historyCount; i++) {
                Transaction t = history[i];
                System.out.println((i + 1) + ". " + t.type + " $" + t.amount);

            }
        }
    }        
    static double CheckBalance(){
        return balance;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(true){
        System.out.printf("1.Add Income\n2.Add Expense\n3.Check Balance\n4.Transaction history\n5.Exit\nEnter your choice\n");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                    System.out.println("enter the income amount");
                    double income=sc.nextDouble();
                    Tracker.addIncome(income);
                    System.out.println();
                     break;
            case 2:
                    System.out.println("enter the expense amount");
                    double expense=sc.nextDouble();
                    Tracker.addExpense(expense);
                    System.out.println();
                    break;
            case 3:
                    System.out.println("your balance is:"+Tracker.CheckBalance()+"\n");
            break;
            case 4:
                     printHistory();
                    break;
            case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
            default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }     
    }   
}

