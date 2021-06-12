import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your choice");
		System.out.println("1.Write To notepad");
		System.out.println("2.Get Age");
		System.out.println("3.Update Height");
		System.out.println("4.Sum of all ages and height");
		byte menu = sc.nextByte();
		sc.nextLine();
		boolean exit =false;
		do {
			switch (menu) {
			case 1://csome change
				try {
					new Operations().writToNotePAd();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.print("Enter name:");
				String name = sc.nextLine();
				double age=new Operations().getAge(name);
				System.out.println("The age of " +name+ "is"  +age);
				break;
			case 3:
				System.out.print("Enter name:");
				String name2 = sc.nextLine();
				System.out.println("enter updated height :");
				double height = sc.nextDouble();
				sc.nextLine();
				String result=new Operations().updateHeight(name2, height);
				System.out.println(result);
				break;
			case 4:
				
			double sum=	new Operations().creatTotal();
			System.out.println("The sum of total age is "+sum);
				break;
			case 0:
				exit = true;
				break;
			}

			if (exit)
				break;
			System.out.print("Choose action from menu : ");
			menu = sc.nextByte();
			sc.nextLine();

		} while (!exit);
		System.out.println("Exited!!!");
		sc.close();
	}
}
