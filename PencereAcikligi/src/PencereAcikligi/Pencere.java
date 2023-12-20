package PencereAcikligi;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Pencere {
	private final FIS fis;
	private final double oksijenMiktari;
	private final double yagisMiktari;
	
	public Pencere(double oksijenMiktari, double yagisMiktari) throws URISyntaxException{
		this.oksijenMiktari=oksijenMiktari;
		this.yagisMiktari=yagisMiktari;
		File file =new File(getClass().getResource("Pencere.fcl").toURI());
		fis=FIS.load(file.getPath(),true);
		fis.setVariable("oksijenMiktari",oksijenMiktari);
		fis.setVariable("yagisMiktari",yagisMiktari);
		fis.evaluate();
	}
	@Override
	public String toString() {
		
		return "Açıklık miktari:" +Math.round(fis.getVariable("aciklikMiktari").getValue())+" cm aciklik onerilmektedir";
	}
	public FIS getModel() {
		return fis;
	}

}
