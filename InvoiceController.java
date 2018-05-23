import javax.swing.JOptionPane;
public class InvoiceController {
  InvoiceModel mod = new InvoiceModel();
  private int size ;
  private boolean ok = true;
	
	public void process()
	{   String s = JOptionPane.showInputDialog("Cakto numrin e faturave qe deshironi qe t'i krijoni");
	    if(mod.isNumeric(s))
		{   size = new Integer(s).intValue();
			if(size>0)
		    {   InvoiceView[] locker = new InvoiceView[size];
				while(ok) 
			    {
				  if(!mod.check(locker)) { createAnInvoice(locker); }
				  else { manageInvoice(locker);}
			    }
			}
			else 
			{ JOptionPane.showMessageDialog(null, "Gabim! Numri duhet te jete me i madh se 0");
			  this.process();
		    }
        }
	}
	
	//Metoda private qe perdoren nga kjo klase
	
	private void manageInvoice(InvoiceView[] locker)
	{  if(mod.checkIfIsFull(locker))
	    { String s = JOptionPane.showInputDialog(" Nese deshiron te shikosh nje fature shtyp 2" + 
	      "\n Nese deshiron te fshish nje fature shtyp 3"
	       + "\n Nese deshiron te ndalosh programin shtyp 4");
	    switch(s)
		  { 
	        case "2": displayAnInvoice(locker) ;
		    break;
		    case "3": deleteAnInvoice(locker);
		    break;
		    case "4": ok=false;
		    break;
		    default:
		    System.out.println("Gabim ne komande");
		  }
		
	    }
	
	else {
		
		String s = JOptionPane.showInputDialog(" Nese deshiron te krijosh nje fature shtyp 1"
				+ "\n Nese deshiron te shikosh nje fature shtyp 2" + 
			      "\n Nese deshiron te fshish nje fature shtyp 3"
			       + "\n Nese deshiron te ndalosh programin shtyp 4");
			    switch(s)
				  { case "1": createAnInvoice(locker);
				    break;
			        case "2": displayAnInvoice(locker) ;
				    break;
				    case "3": deleteAnInvoice(locker);
				    break;
				    case "4": ok=false;
				    break;
				    default:
				    System.out.println("Gabim ne komande");
				  }
	}
	
	
	}
	
	
	private void createAnInvoice(InvoiceView[] vargu)
	{     String s = JOptionPane.showInputDialog("Cakto numrin e fatures");
	      if(mod.isNumeric(s))
	      {
		  int i = new Integer(s).intValue();
		  if(i<size && i>=0)
		  { if(!mod.check(vargu, i))
		      {
			    String s1 = JOptionPane.showInputDialog("Sa produkte do t'i permbaj fatura?");
			    if(mod.isNumeric(s1))
			    {   int n = new Integer(s1).intValue();
				    String[] produktet = new String[n];
				    produktet = mod.setProducts(n);
				    double[] cmimet = new double[n];
				    cmimet = mod.setPrices(produktet);
				    vargu[i] = new InvoiceView(mod.setDates(), produktet, cmimet);
			    }
		      }
		    else { JOptionPane.showMessageDialog(null, "Nuk mund ta krijosh faturen me numrin " + i + " sepse ekziston"); }
		  }
		  else { JOptionPane.showMessageDialog(null, "GABIM! Nuk mund te zgjedhesh numrin me te madh se " + (size-1));}
	      }  
	 }
	
	
	private void deleteAnInvoice(InvoiceView[] vargu)
	{
		int i = new Integer(JOptionPane.showInputDialog("Cilen fatur deshiron ta fshish \n (Shembull: shtyp 1 per faturen numer 1)")).intValue();
		if(i<size && mod.check(vargu, i))
		{
			mod.delete(vargu, i);
		}
		else JOptionPane.showMessageDialog(null, "GABIM, fatura nuk ekziston");
	}
	
	private void displayAnInvoice(InvoiceView[] vargu)
	{ 
		int i = new Integer(JOptionPane.showInputDialog("Cilen fatur deshiron ta shikosh")).intValue();
	 
	    if(i<size && mod.check(vargu, i))
	     {
		    vargu[i].display();
         }
	    else JOptionPane.showMessageDialog(null, "GABIM, fatura nuk ekziston");
		
	}

}
