package calculator_project_Main;

import java.util.Scanner;

public class Solution_Calculator {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);

		//UPCASTING
		Calculator c=new CalculatorImplement();

		//MENU DRIVEN PORGAMM

		while(true)
		{
			System.out.println("1:addition\n2 :substraction\n3 :multiplication\n4 :division\n5 :Exite");

			int choice =scan.nextInt();

			int a=0;
			int b=0;
			if(choice>=1 && choice<=4) {
				System.out.println("enter the 2 numbers");
				a=scan.nextInt();
				b=scan.nextInt();
			}

			switch (choice) {
			case 1:
				System.out.println("sum of "+a+"& "+b+" is "+c.add(a, b));

				break;

			case 2:
				System.out.println("substaction of "+a+"& "+b+" is "+c.sub(a, b));

				break;

			case 3:
				System.out.println(" multiplication of "+a+"&"+b+" is "+c.multi(a, b));

				break;

			case 4:
				int resu=c.div(a, b);
				if(resu!=0) {
					System.out.println("div of "+a+" &"+b+" is ");
				}
				else
				{
					System.out.println("numrator or dinaminator does not be 0");
				}
				break;

			default :
				System.out.println(c.displayString());
				break;
			}
			System.out.println("===================");

		}
	}

}

