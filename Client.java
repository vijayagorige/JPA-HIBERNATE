package client;
import java.util.Scanner;
import service.Service;

public class Client {
	public static void main(String[] args) {
		String mobileid;
		//creating object to Service class
		Service service=new Service();
		Scanner sc=new Scanner(System.in);
		int num=1;
		//checking this condition
		while(num==1)
		{
			System.out.println(" 1.Insert \n 2.Update \n 3.display \n 4.displays \n 5.delete\n 6.search");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			//switch case
			switch(choice)
			{
			case 1:
			{
				//implementing insert method
				service.insert();
				break;
			}
			case 2:
			{
				//implementing update method
				service.update();
				break;
			}
			case 3:
			{
				//implementing display method
				System.out.println(service.display());
				break;
			}
			case 4:
			{
				//implementing displays method
				System.out.println(service.displays());
				break;
			}
			case 5:
			{
				//implementing delete method
				System.out.println("Enter mobile id in mobiles to delete");
				sc.nextLine();
				mobileid=sc.nextLine();
				service.delete(mobileid);
				break;
			}
			case 6:
	           {
	        	 //implementing search method
	        	   System.out.println(service.search());
	        	   break;
	           }
			}
			System.out.println("Enter 1 for continue 0 for exist");
	        num=sc.nextInt();
		}
	}

}
