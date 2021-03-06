//Group Member: CHAN CHIU CHUN,LI KEE YIU
import java.util.Scanner;

public class TaxComputator {
	
	 
	public static double MPFcalculator(double income){			//sub function MPF
		double MPF = income * 0.05;
		if (MPF >= 18000)
		{
			MPF = 18000;			//18000 Limit
		}
		return MPF;
	}
	
	public static double Netincome(double income,double MPF){
		double netincome = income - MPF - 132000;			//Single Allowance
		return netincome;
	}
	
	public static double combineNetincome(double income,double wincome,double MPF,double WMPF){
		double netincome = income + wincome - MPF - WMPF - 264000;			//Couple Allowance
		return netincome;
	}
	
	
	public static double taxCal(double netincome){
		double total = 0;
		
		if (netincome <=0){
			total = 0;
			}else if(netincome <=50000){
				total =netincome*0.02;
				}
				else if (netincome <=100000){
					total = 50000*0.02+(netincome-50000)*0.06;
					}else if(netincome <= 150000){
						total = 50000*0.02+50000*0.06+(netincome-100000)*0.10;
						}else if(netincome <= 200000){
							total = 50000*0.02+50000*0.06+50000*0.10+(netincome-150000)*0.14;
							}else if(netincome >=200000){
								total = 50000*0.02+50000*0.06+50000*0.10+50000*0.14+(netincome-200000)*0.17;
								}
		return total;
	}
	
	public static double standard(double income){
		double total;
		total = income - 18000;
		total = total *0.15;
		return total;
	}
	
	public static double comStandard(double income,double wincome,double MPF,double WMPF){
		double total;
		total = income+wincome-MPF-WMPF;
		total = total *0.15;
		return total;
	}
	

	 public static void marriedcalculator(double income,double wifeincome) {
	        // TODO code application logic here
	        double ComSTax;
	        double ComPTax;
	        double Htax = 0;
	        double Wtax = 0;
	        double ComTax;
		 	double HMPF = MPFcalculator(income);
	        double WMPF = MPFcalculator(wifeincome);
	        
	        
	        double HNetIncome= Netincome(income,HMPF);
	        double WNetIncome= Netincome(wifeincome,WMPF);
	        
	        double CombineNet = HNetIncome + WNetIncome;
	       
	        double hStax = standard(income);
	        double hPtax = taxCal(HNetIncome);

	        double wStax = standard(wifeincome);
	        double wPtax = taxCal(WNetIncome);
	      
	        ComSTax = comStandard(income,wifeincome,HMPF,WMPF);
	        ComPTax = taxCal(CombineNet);


	        if (CombineNet <= 0 ){
	        	System.out.println("You don't need to pay Tax if you combine together.");
		        System.out.println("-----------------------------------------------");
	        }else{
	        	if(ComSTax >= ComPTax){
	        System.out.println("If you combine the tax will be:(Progressive)");
	        System.out.println("-----------------------------------------------");
	        System.out.println(ComPTax);
	        ComTax = ComPTax;
	        	}else{
	        		 System.out.println("If you combine the tax will be:(Standard)");
	     	        System.out.println("-----------------------------------------------");
	     	        System.out.println(ComSTax);
	     	        ComTax =ComSTax;
	        	}
	        }
	        
	        System.out.println("If you pay the tax in divided:");	        
	        System.out.println("-----------------------------------------------");
	        
	        if(HNetIncome <= 0){
	        	System.out.println("Husband don't need to pay tax.");
	        }else{
	        	if(hStax <= hPtax){
	        		System.out.println("Husband Tax:(Standard) " + hStax);
	        		Htax = hStax;
	        	}else
	        	System.out.println("Husband Tax:(Progressive) " + hPtax);
	        	Htax = hPtax;
	        }
	        
	        if(WNetIncome <= 0 ){
	        	System.out.println("Wife don't need to pay tax.");
		        System.out.println("-----------------------------------------------");
	        }else{
	        	if(wPtax <= wStax){
	        		System.out.println("Wife Tax:(Progressive) " + wPtax);
	    	        System.out.println("-----------------------------------------------");
	    	        Wtax = wPtax;
	        	}else{
	        System.out.println("Wife Tax:(Standard) " + wStax);
	        System.out.println("-----------------------------------------------");
	        Wtax = wStax;
	        }
	        
	        if((Htax+Wtax) !=0 ){
	        	System.out.println("The total Tax pay if pay in divided would be: " + (Htax+Wtax));
	        }
	    }
	 }
	    
	    
	    public static void singlecalculator(double income) {
	    	double STax,PTax;
	        double MPF = MPFcalculator(income);
	        System.out.println("Your MPF is: " + MPF);
	        double NetIncome = Netincome(income,MPF);
	        if(NetIncome <= 0){
	        	System.out.println("Your don't need to pay tax,Thank you.");
	        }else{
	        System.out.println("Your Netincome is: " + NetIncome);
			STax = standard(income);
	        PTax = taxCal(NetIncome);
			if(PTax >= STax){
	        System.out.println("The tax total you need to pay:(Standard) "+ STax);
	        }else{
	         System.out.println("The tax total you need to pay:(Progressive) "+ PTax);
	        }
	        	
	        }
	    }
	    
	    
	     public static void main(String[] args) {
	        double income = 0;
	        double wifeincome = 0;
	        String checkVar;
	        System.out.println("Salaries Tax Calculator");
            System.out.println("Are you married?(Y/N)");    //check marriage status
            Scanner Checkscn = new Scanner(System.in);
            checkVar = Checkscn.nextLine();      //User input Y and N to choose the calculator
            switch(checkVar){
            case "N":
            	System.out.println("Please input your income for the year of assessment：");
    	        if(income == 0){
    	        Scanner scn2 = new Scanner(System.in);
    	        income = scn2.nextDouble();
    	        }
    	        singlecalculator(income);       //passing variable to function
    	        break;
            case "Y":
            	System.out.println("Please input you and your wife income for the year of assessment：");
	            System.out.println("Husband year of assessment:");      //husband income
	            Scanner scn3 = new Scanner(System.in);
	            income = scn3.nextDouble();
	            System.out.println("Wife year of assessment:");
	            Scanner wifescn = new Scanner(System.in);       //wife income
	            wifeincome =wifescn.nextDouble();
	            marriedcalculator(income,wifeincome);   //passing variable to function
            }
	     }
}
