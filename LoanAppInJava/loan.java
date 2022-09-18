import java.util.Scanner;
public class loan{
	public static void main(String[] args) {
		Scanner myScanner = new Scanner (System.in);
   
// home adress 
         System.out.print("enter your home address :");
         String home = myScanner.nextLine();

		// prompt  user to enter loan amount
		System.out.print("please enter the amount of loan you want to borrow :$");
		double loanAmount = myScanner.nextDouble();


		// prompt user to enter YEAR of repayment
		System.out.print("Enter number of years as an integer, e.g.,5 :");
         int numOfYears = myScanner.nextInt();


          // mobile number
         System.out.print("enter your mobile number :");
         double num = myScanner.nextDouble();

   

         // salary
         System.out.print("what is the amount of your salary :");
         double salary = myScanner.nextDouble();

         if(salary<100){
         	System.out.print("you are not elegible for this loan due to your low income");
         }else{
         	System.out.print("your application to borrow :$"+ loanAmount + " has been recieve ");
         }
	}
}