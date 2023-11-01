package dao;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entity.MobileDetails;
import entity.PurchaseDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DaoImpl {
	//instance variables
		String mobileid;
        String name;
	    float price;
		int quantity;
		PurchaseDetails purchasedetails;
		int purchase_id;
    	String cname;
    	String mailId;
        String phoneno;
        Date purchasedate=new Date(); 
        MobileDetails mobiles;
		Scanner sc=new Scanner(System.in);
		//insert method
		public void insert()
		{
			//creating object to EntityManagerFactory
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
		//creating object to EntityManager
		EntityManager em=emf.createEntityManager();
		//transaction begins
        em.getTransaction().begin();
        MobileDetails md=new MobileDetails(mobileid,name,price,quantity,purchasedetails);
        PurchaseDetails pd=new PurchaseDetails(purchase_id,cname,mailId,phoneno,purchasedate,mobiles);
        System.out.println("Enter mobile id");
        mobileid=sc.nextLine();
        md.setMobileid(mobileid);
        //regex expressions
        String id= "/^\\d{4}$/";
        Pattern pattern3 = Pattern.compile(id);
        Matcher matcher3= pattern3.matcher(mobileid);
        boolean match3=matcher3.matches();
        try
        {
            if(match3==matcher3.matches());
            pd.setMailId(cname);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        System.out.println("Enter mobile name");
        name=sc.nextLine();
        md.setName(name);
        System.out.println("Enter mobile price");
        price=sc.nextFloat();
        md.setPrice(price);
        System.out.println("Enter mobile quantity");
        sc.nextLine();
        quantity=sc.nextInt();
        md.setQuantity(quantity);
        md.setPurchasedetails(pd);
        //throwing exception
        try
        {
        	if(quantity>0)
        	{
            sc.nextLine();
            System.out.println("Enter customer name");
            cname=sc.nextLine();
            pd.setCname(cname);
            //regex expressions
            String name = "([A-Z]+(a-z){19})";
            Pattern pattern2 = Pattern.compile(name);
            Matcher matcher2= pattern2.matcher(cname);
            boolean match2=matcher2.matches();
            //throwing exception
            try
            {
                if(match2==matcher2.matches());
                pd.setMailId(cname);
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            System.out.println("Enter customer mail id");
            mailId=sc.nextLine();
            pd.setMailId(mailId);
            //regex expressions
            String mail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern1 = Pattern.compile(mail);
            Matcher matcher1= pattern1.matcher(mailId);
            boolean match1=matcher1.matches();
            //throwing exception
            try
            {
                if(match1==matcher1.matches());
                pd.setMailId(mailId);
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            System.out.println("Enter customer phone no");
            phoneno=sc.nextLine();
            pd.setPhoneno(phoneno);
            //regex expressions
            String regex = "([0-9]{10})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phoneno);
            boolean match=matcher.matches();
            //throwing exception
            try
            {
                if(match==matcher.matches());
                pd.setPhoneno(phoneno);
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            pd.setMobiles(md);
            em.persist(md);
            em.persist(pd);
            //saving transaction
            em.getTransaction().commit();
            System.out.println("Record Inserted Successfully");
			System.out.println("-------------------------------------");
            em.close();
            emf.close();
        }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		}
		public void update()
		{
			//creating object to EntityManagerFactory
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
			//creating object to EntityManager
			EntityManager em=emf.createEntityManager();
			//transaction begins
	        em.getTransaction().begin();
	        MobileDetails md=new MobileDetails(mobileid,name,price,quantity,purchasedetails);
	        PurchaseDetails pd=new PurchaseDetails(purchase_id,cname,mailId,phoneno,purchasedate,mobiles);
	        System.out.println("Enter mobile id to find");
	        mobileid=sc.nextLine();
			md=em.find(MobileDetails.class,mobileid);
	        System.out.println("Enter mobile quantity to update");
	        quantity=sc.nextInt();
	        md.setMobileid(mobileid);
	        md.setQuantity(quantity);
	        System.out.println(md);
	        //saving transaction
			em.getTransaction().commit();
			System.out.println("Record Updated Successfully");
			System.out.println("-------------------------------------");
			em.close();
			emf.close();
		}
		public List<MobileDetails>display()
		{
			//creating object to EntityManagerFactory
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
			EntityManager em=emf.createEntityManager();
			//transaction begins
			em.getTransaction().begin();
			MobileDetails md=new MobileDetails(mobileid,name,price,quantity,purchasedetails);
			//named query implementing
		    Query query=em.createNamedQuery("display");
		    @SuppressWarnings("unchecked")
		    List<MobileDetails>list1=query.getResultList();
		    return list1;
		}
		public List<PurchaseDetails>displays()
		{
			//creating object to EntityManagerFactory
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
			//creating object to EntityManager
			EntityManager em=emf.createEntityManager();
			//transaction begins
			em.getTransaction().begin();
			PurchaseDetails pd=new PurchaseDetails(purchase_id,cname,mailId,phoneno,purchasedate,mobiles);
		    Query query=em.createNamedQuery("displays");
		    @SuppressWarnings("unchecked")
		    List<PurchaseDetails>list2=query.getResultList();
		    return list2;
		}
		public void delete(String mobileid)
		{
			//creating object to EntityManagerFactory
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
			//creating object to EntityManager
			EntityManager em=emf.createEntityManager();
			//transaction begins
			em.getTransaction().begin();
			MobileDetails md=new MobileDetails(mobileid,name,price,quantity,purchasedetails);
			PurchaseDetails pd=new PurchaseDetails(purchase_id,cname,mailId,phoneno,purchasedate,mobiles);
			md=em.find(MobileDetails.class,mobileid);
			em.remove(md);
			System.out.println(md);
			//saving transaction
			em.getTransaction().commit();
			System.out.println("Record Deleted Successfully");
			System.out.println("-------------------------------------");
			em.close();
			emf.close();
		}
		public List<MobileDetails> search()
		{
			//creating object to EntityManagerFactory
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
			//creating object to EntityManager
			EntityManager em=emf.createEntityManager();
			//transaction begins
			em.getTransaction().begin();
			//customized query
			Query q=em.createQuery("select x from MobileDetails x order by x.price asc");
			List<MobileDetails>list3=q.getResultList();
			return list3;
		}
}
