package Bankingmanagment;

import java.sql.*;
import java.util.Scanner;

public class TransactionManager {
    private Connection connection;
    private Scanner scanner;

    TransactionManager(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    public String selectacc ="SELECT * FROM Accounts WHERE account_number = ? and security_pin = ? ";
    public String creditbal = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ?";
    public String debitbal = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ?";
    public void debit_money(long account_number) throws SQLException {
        scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Security Pin: ");
        String security_pin = scanner.nextLine();


        try {
            connection.setAutoCommit(false);
            if(account_number!=0) {
                PreparedStatement p1 = connection.prepareStatement(selectacc);
                p1.setLong(1, account_number);
                p1.setString(2, security_pin);
                ResultSet resultSet = p1.executeQuery();
                if (resultSet.next()) {
                    double current_balance = resultSet.getDouble("balance");
                    if (amount<=current_balance){
                        PreparedStatement p2 = connection.prepareStatement(debitbal);
                        p2.setDouble(1, amount);
                        p2.setLong(2, account_number);
                        int rowsAffected = p2.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Rs."+amount+" debited Successfully");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        } else {
                            System.out.println("Transaction Failed!");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }
                    }else{
                        System.out.println("Insufficient Balance!");
                    }
                }else{
                    System.out.println("Invalid Pin!");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
    }
    public void credit_money(long account_number)throws SQLException {
        scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Security Pin: ");
        String security_pin = scanner.nextLine();
        try {
            connection.setAutoCommit(false);
            if(account_number != 0) {
                PreparedStatement preparedStatement = connection.prepareStatement(selectacc);
                preparedStatement.setLong(1, account_number);
                preparedStatement.setString(2, security_pin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {

                    PreparedStatement preparedStatement1 = connection.prepareStatement(creditbal);
                    preparedStatement1.setDouble(1, amount);
                    preparedStatement1.setLong(2, account_number);
                    int rowsAffected = preparedStatement1.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Rs."+amount+" credited Successfully");
                        connection.commit();
                        connection.setAutoCommit(true);
                        return;
                    } else {
                        System.out.println("Transaction Failed!");
                        connection.rollback();
                        connection.setAutoCommit(true);
                    }
                }else{
                    System.out.println("Invalid Security Pin!");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
    }

    public void getBalance(long account_number){
        scanner.nextLine();
        System.out.print("Enter Security Pin: ");
        String security_pin = scanner.nextLine();
        String getbal = "SELECT balance FROM Accounts WHERE account_number = ? AND security_pin = ?";
        try{
            PreparedStatement p1 = connection.prepareStatement(getbal);
            p1.setLong(1, account_number);
            p1.setString(2, security_pin);
            ResultSet resultSet = p1.executeQuery();
            if(resultSet.next()){
                double balance = resultSet.getDouble("balance");
                System.out.println("Balance: "+balance);
            }else{
                System.out.println("Invalid Pin!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void transfer_money(long sender_account_number) throws SQLException {
        scanner.nextLine();
        System.out.print("Enter Receiver Account Number: ");
        long receiver_account_number = scanner.nextLong();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Security Pin: ");
        String security_pin = scanner.nextLine();
        try{
            connection.setAutoCommit(false);
            if(sender_account_number!=0 && receiver_account_number!=0){
                PreparedStatement p1 = connection.prepareStatement(selectacc);
                p1.setLong(1, sender_account_number);
                p1.setString(2, security_pin);
                ResultSet resultSet = p1.executeQuery();

                if (resultSet.next()) {
                    double current_balance = resultSet.getDouble("balance");
                    if (amount<=current_balance){
                        PreparedStatement pd = connection.prepareStatement(debitbal);
                        pd.setDouble(1, amount);
                        pd.setLong(2, sender_account_number);
                        int rowsAffected1 = pd.executeUpdate();

                        PreparedStatement pc = connection.prepareStatement(creditbal);
                        pc.setDouble(1, amount);
                        pc.setLong(2, receiver_account_number);
                        int rowsAffected2 = pc.executeUpdate();
                        if (rowsAffected1 > 0 && rowsAffected2 > 0) {
                            System.out.println("Transaction Successful!");
                            System.out.println("Rs."+amount+" Transferred Successfully");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        } else {
                            System.out.println("Transaction Failed");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }
                    }else{
                        System.out.println("Insufficient Balance!");
                    }
                }else{
                    System.out.println("Invalid Security Pin!");
                }
            }else{
                System.out.println("Invalid account number");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
    }

}

