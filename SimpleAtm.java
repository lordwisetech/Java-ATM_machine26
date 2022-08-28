import java.util.Scanner;
public class Simpleatm{
	public static void main(String[] args) {
		int ballance=0,
		 whitdrawal, 
		 deposit;
		 // creat a Scaanner object
		 Scanner sc = new Scanner (System.in);
		 while (true){
		 	System.out.println("Automated Teller Machine");
		 	System.out.println("Choose 1 for whitdrawal");
		 	System.out.println("Choose 2 for deposit");
		 	System.out.println("Choose 3 for ballance");
		 	System.out.println("Choose 4 to exit this section");
		 	System.out.println("   Choose the operation you want to perform");
		 	int choice = sc.nextInt();
		 	switch(choice){
		 	case 1:
		 		System.out.println("enter the amount to be whitdraw");
		 		whitdrawal = sc.nextInt();
		 		if(ballance >= whitdrawal){
		 			ballance = whitdrawal - ballance;
		 			System.out.println("you have succesfuly whitdraw :$" + whitdrawal +" from your account");
		 		}else{
		 			System.out.println("opps, Insuficient ballance");

		 		}
		 		break;
		 	case 2:
		 		System.out.println("Enter money to be deposited");
		 		deposit = sc.nextInt();
		 		ballance = deposit + ballance;
		 		System.out.println("your account has been credited with :$" + deposit);
		 		break;
		 	case 3:
		 		System.out.println("Your ballance is :$" + ballance);
		 		break;
		 	case 4:
		 		System.out.println("Thank you for banking with us");
		 		System.exit(0);
		 	}
		 }
	}
}