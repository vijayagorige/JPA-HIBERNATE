package entity;
//entity layer
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//creating table
@Entity
//modifying table name
@Table(name="purchasedetails")
public class PurchaseDetails implements Serializable
{
	private static final long serialVersionUID=1L;
	//primary key
	@Id
	//Auto generation of values
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int purchase_id;
	//instance variables
	private String cname;
	private String mailId;
	private String phoneno;
	private Date purchasedate=new Date();
	//OneToOne mapping
	@OneToOne(cascade=CascadeType.ALL)
	//foreign key
	@JoinColumn(name="mobileid",referencedColumnName="mobileid")
	private MobileDetails mobiles;
	//parameterised constructor
	public PurchaseDetails(int id,String name,String maid,String ph,Date da,MobileDetails md)
	{
		this.purchase_id=id;
		this.cname=name;
		this.mailId=maid;
		this.phoneno=ph;
		this.purchasedate=da;
		this.mobiles=md;
	}
	//default constructor
	public PurchaseDetails()
	{
		
	}
	//setters and getters
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	public MobileDetails getMobiles() {
		return mobiles;
	}
	public void setMobiles(MobileDetails mobiles) {
		this.mobiles = mobiles;
	}
	@Override
	public String toString()
	{
		return "Purchase id:"+purchase_id+" customer name:"+cname+" mail id:"+mailId+" phone no:"
				+phoneno+" purchased date:"+purchasedate+" mobile id: "+mobiles;
	}
}
