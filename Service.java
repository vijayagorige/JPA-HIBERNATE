package service;
import java.util.List;
import java.util.Scanner;
import dao.DaoImpl;
import entity.MobileDetails;
import entity.PurchaseDetails;

public class Service
{
	Scanner sc=new Scanner(System.in);
	//creating object to DaoImpl class
	DaoImpl dao=new DaoImpl();
	//insert method
	public void insert()
	{
		dao.insert();
	}
	//update method
	public void update()
	{
		dao.update();
	}
	//display method for MobileDetails class
	public List<MobileDetails>display()
	{
		return dao.display();
	}
	//displays method for PurchaseDetails class
	public List<PurchaseDetails> displays()
	{
		return dao.displays();
	}
	//delete method
	public void delete(String mobileid)
	{
		dao.delete(mobileid);
	}
	//search method
	public List<MobileDetails> search()
	{
		return dao.search();
	}
}
