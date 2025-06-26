
        // Methods: addBook, issueBook, returnBook, showAvailableBooks
        // Properties: Array to store the available books,
        // Array to store the issued books

import java.util.Scanner;

class Librarybook{
    String[] books=new String[5];
    boolean[] isIssued = new boolean[5];
    Scanner sc= new Scanner(System.in);
    public void addbook(){
        System.out.println("enter 5 books");
        for(int i=0;i<5;i++){
            books[i]=sc.next();
            isIssued[i]=false;
        }
       
    }
    public void showbook(){
        System.out.println("These are the available books");
        for(int i=0;i<5;i++){
           if(!isIssued[i]){
            System.out.print((i+1)+")"+books[i]+" ");
            }
        }
    }
        
    public void issuebook(){
        showbook();
        System.out.print("Enter the book number to issue: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice < 1 || choice > 5) {
            System.out.println("Invalid book number.");
        } else if (isIssued[choice - 1]) {
            System.out.println("Book already issued.");
        } else {
            isIssued[choice - 1] = true;
            System.out.println("Book \"" + books[choice - 1] + "\" issued successfully.");
        }

    }
    public void returnbook(){
        System.out.print("Enter the book number to return: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice < 1 || choice > 5) {
            System.out.println("Invalid book number.");
        } else if (!isIssued[choice - 1]) {
            System.out.println("Book was not issued.");
        } else {
            isIssued[choice - 1] = false;
            System.out.println("Book \"" + books[choice - 1] + "\" returned successfully.");
        }

    } 
}
public class library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Librarybook l = new Librarybook();
        l.addbook();

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show available books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    l.showbook();
                    break;
                case 2:
                    l.issuebook();
                    break;
                case 3:
                    l.returnbook();
                    break;
                case 4:
                    System.out.println("Thank you for using the library system!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
