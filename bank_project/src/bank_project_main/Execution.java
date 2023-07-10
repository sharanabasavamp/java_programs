package bank_project_main;

import java.util.Scanner;

import custom_exceptions.InvalidChoiceException;

public class Execution {

	public static void main(String[] args) {

		Scanner scan =new Scanner(System.in);

		Bank bank=new Bank_implement(00);
		//   DOWNCAST

		while(true)
		{

			System.out.println("1 : DEPOSTE \n2 : WITHDRAW \n3 : CHECK BALANCE \n4 : EXITE");

			System.out.println("Enter choice");
			int choice=scan.nextInt();		

			switch (choice)
			{
			case 1:
				System.out.println("enter Ammount to  be Deposite");
				int ammountTodeposite=scan.nextInt();
				bank.deposite(ammountTodeposite);
				break;


			case 2:
			{
				System.out.println("Enter ammount to be withdraw");
				int ammountToWithdraw=scan.nextInt();
				bank.withdrow(ammountToWithdraw);
				break;
			}

			case 3:
				System.out.println("your Avilable Balanced is ="+bank.getbal());
				break;

			case 4:
				System.out.println("Thank You Visit Again");
				System.exit(0);
				break;

			default:
				if(choice==0 || choice <4)
				{
					//exception
					try {
						throw new InvalidChoiceException("Invalid choice please enter a valid choice");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}


			}

		}

	}
}
