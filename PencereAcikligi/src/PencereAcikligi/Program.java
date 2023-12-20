package PencereAcikligi;

	import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
	import net.sourceforge.jFuzzyLogic.rule.Rule;
	public class Program {

		public static void main(String[] args) {
		    double oksijenMiktari ;
		    double yagisMiktari ;
			do {
			Scanner in =new Scanner(System.in);
			System.out.print("Oksijen miktarini giriniz yüzde olarak giriniz (11'den az 26 dan fazla olmamalı): ");
		    oksijenMiktari=in.nextDouble();
			System.out.print("Yagis miktarini kilogram/m^2 cinsinden giriniz (0'dan az 100 den fazla olmamalı): ");
			yagisMiktari=in.nextDouble();
			if ((oksijenMiktari>26 || yagisMiktari>100 || oksijenMiktari<11 || yagisMiktari<0)) {
	            System.out.println("Lütfen değerleri aralıklara göre giriniz!!!");
	        }
			}
			while(oksijenMiktari>26 || yagisMiktari>100 || oksijenMiktari<11 || yagisMiktari<0) ;
			try {
				Pencere pencere =new Pencere (oksijenMiktari,yagisMiktari);
				var kurallar=pencere.getModel().getFunctionBlock("Pencere").getFuzzyRuleBlock("kuralBlok").getRules();
				
				for(var kural:kurallar) {
					if(kural.getDegreeOfSupport()>0) {
						System.out.println(kural);
					}
				}
				
				System.out.print(pencere);
				JFuzzyChart.get().chart(pencere.getModel().getVariable("aciklikMiktari").getDefuzzifier(),"Aciklik Miktari",true);
				
			}
			catch(Exception e){
				System.out.print(e.getMessage());

			}
		
		
			}
		
		
		
	}