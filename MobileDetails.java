package entity;
//entity layer
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//creating Table
@Entity
//named queries
@NamedQueries(@NamedQuery(name = "display", query = "SELECT details FROM MobileDetails details"))
@NamedQuery(name = "displays", query = "SELECT details FROM PurchaseDetails details")
//modifying table name
@Table(name="mobiles")
public class MobileDetails
{
	//primary key
	@Id
	private String mobileid;
	//instance variables
	private String name;
	private float price;
	private int quantity;
	//OneToOne Mapping
	@OneToOne(mappedBy="mobiles")
	private PurchaseDetails purchasedetails;
	//parameterised constructor class
	public MobileDetails(String id,String name,float price,int quantity,PurchaseDetails pd)
	{
		this.mobileid=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.purchasedetails=pd;
	}
	//default constructor
	public MobileDetails()
	{
		
	}
	//setters and getters
	public String getMobileid() {
		return mobileid;
	}
	public void setMobileid(String mobileid) {
		this.mobileid = mobileid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public PurchaseDetails getPurchasedetails() {
		return purchasedetails;
	}
	public void setPurchasedetails(PurchaseDetails purchasedetails) {
		this.purchasedetails = purchasedetails;
	} 
	@Override
	public String toString()
	{
		return "Mobile id: "+mobileid+" mobile name: "+name+" mobile price "+price+" quantity: "
				+quantity+"\n";
	}
}
