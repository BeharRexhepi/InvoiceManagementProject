import javax.swing.JOptionPane;

public class InvoiceModel {
	
	
	public String[] setDates()
	{  
	
		String[] data = new String[8];
		data[0] = JOptionPane.showInputDialog("Shkruaj numrin e fatures");
		data[1] = JOptionPane.showInputDialog("Shkruaj daten");
		data[2] = JOptionPane.showInputDialog("Shkruaj emrin");
    	data[3] = JOptionPane.showInputDialog("Shkruaj emrin e kompanis");
		data[4] = JOptionPane.showInputDialog("Shkruaj adresen");
		data[5] = JOptionPane.showInputDialog("Shkruaj qytetin");
		data[6] = JOptionPane.showInputDialog("Shkruaj numrin e telefonit");
		data[7] = JOptionPane.showInputDialog("Shkruaj email adresen");
		for(int i = 0; i<data.length; i++)
		{
			if(data[i]==null)data[i]="";
		}
		
		
		return data;
    
	}
	
	
	public String[] setProducts(int n)
	{  String[] products = new String[n];
	   for(int i=0; i<products.length; i++)
	   {   String s = JOptionPane.showInputDialog("Shkruaj produktin e " + (i+1));
	       if(s!=null)
		   products[i]=s;
	       else
	       i--; // nderpritet programi ne menyre qe mos te shfaqen errora me vone
	   }
	   return products;
	}
	
	
	public double[] setPrices( String[] vargu)
	{ int n = vargu.length;
		double[] prices = new double[n];
	   for(int i=0; i<prices.length; i++)
	   {   String s = JOptionPane.showInputDialog("Shkruaj cmimin e produktit " + vargu[i]);
	       if(isNumeric(s))
		   prices[i]= Double.parseDouble(s);
	       
	   }
	   return prices;
	}
	

	
	
	public boolean check(InvoiceView[] vargu)
	{  boolean ok = false;
		for(int i = 0; i<vargu.length; i++)
	  { if(vargu[i]!=null)ok=true;
		
	  }
		return ok;
	}
	
	
	public boolean check(InvoiceView[] vargu, int n)
	{ boolean ok = false;
		if(vargu[n] != null) ok = true;
		return ok;
	}
	
	
	public boolean checkIfIsFull(InvoiceView[] vargu)
	{ boolean ok = true;
	  for(int i = 0; i<vargu.length; i++)
	  {
		  if(vargu[i]==null) ok = false;
	  }
	  return ok;
		
	}
	
	
	public void delete(InvoiceView[] vargu, int i)
	{  
	   if(check(vargu) && vargu[i]!=null)
	   {
		  vargu[i]=null;
		  JOptionPane.showMessageDialog(null, "Fatura numer " + i +" eshte fshire me sukses");
		  
	   }
	   
	   else  { JOptionPane.showMessageDialog(null, "Fatura numer " + i +" nuk ekziston"); }
	  
	}
	
	
	public  boolean isNumeric(String str)  
	{  boolean rez = true;
	  if(str==null)
	  {  rez= false;
	    nullProblem();
	  }
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    rez= false;
	    JOptionPane.showMessageDialog(null, "GABIM! Ke shkruajtur tekst ne vend te numrit");
	    System.exit(0);
	  }  
	  return rez;  
	}
	
	
	private void nullProblem()
	{
		JOptionPane.showMessageDialog(null, "Nuk lejohet butoni cancel ne kete fushe");
		System.exit(0);
	}
	
	
	

}
