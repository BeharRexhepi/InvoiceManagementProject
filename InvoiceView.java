import javax.swing.*;
import java.awt.*;
public class InvoiceView extends JPanel
{  private String InvoiceNr,Date,Name,CompanyName,StreetAddress, City, Phone, Email;
   
   private String[] products = new String[] {};
   private double[] prices = new double[] {};
   private int i = 5;
   private double total = 0;
	public InvoiceView(String[] vargu, String[] produktet, double[] cmimet)
	{
		   InvoiceNr = vargu[0];
		   Date = vargu[1];
		   Name = "[Name: " + vargu[2] + " ]";
		   CompanyName = "[Company name: " + vargu[3] + " ]";
		   StreetAddress = "[Street address: " + vargu[4] + " ]";
		   City = "[City: " + vargu[5] + " ]";
		   Phone = "[Phone: " + vargu[6] + " ]";
		   Email = "[Email: " + vargu[7] + " ] ";
		   products = produktet ;
		   prices = cmimet ;
		   for(int i=0; i<prices.length; i++)total+=prices[i];

	}
	
	
	public void display()
	{ JFrame frame = new JFrame();
	   frame.setSize(500,700);
	   frame.setVisible(true);
	   frame.getContentPane().add(this);
		
	}
	
	public void paintComponent(Graphics g)
	{   g.setColor(Color.white);
	    g.fillRect(0, 0, 500, 700);
	    
		g.setColor(Color.lightGray);
		g.fillRect(270, 50, 180, 30);
		g.setColor(Color.BLACK);
		g.drawRect(270, 50, 180, 30);
		g.drawLine(270+90, 50, 270+90, 50+30+30);
		g.drawString("INVOICE#", 290, 70);
		g.drawString(InvoiceNr, 290, 100);
		g.drawString("DATE", 390, 70);
		g.drawString(Date, 380, 100);
		g.drawRect(270,80,180,30);
		g.setColor(Color.lightGray);
		g.fillRect(20, 150, 200, 30);
		g.setColor(Color.black);
		g.drawRect(20, 150, 200, 30);
		g.drawString("BILL TO",40,170);
		g.drawString(Name,20, 200);
		g.drawString(CompanyName,20, 220);
		g.drawString(StreetAddress,20, 240);
		g.drawString(City,20, 260);
		g.drawString(Phone,20, 280);
		g.drawString(Email,20, 300);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(20, 340, 430, 20 );
		g.setColor(Color.BLACK);
		g.drawRect(20, 340, 430, 270);
        g.drawLine(360, 340, 360, 340+270);
        g.drawLine(20, 360, 450, 360);
        g.drawLine(20,320+270,430+20,320+270);
        g.drawString("DESCRIPTION", 40, 355);
        g.drawString("AMOUNT", 380, 355);
        g.drawString("TOTAL",300,605);
        for(int i = 0,count=0; i<products.length; i++,count+=20) 
		{
			g.drawString(products[i], 50, 390+count);
			g.drawString(""+prices[i]+"$",390, 390+count);
		}
        g.drawString(""+total +"$",390, 605);
        


	}
	
	
	

}


