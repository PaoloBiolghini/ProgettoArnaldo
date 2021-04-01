package it.unibs.fp.arnaldo.Planetarium;

public class CorpoCeleste {
private String codiceID ; //codice univoco
	
	private double massa ;

	private double coordinataX ; //coordinate rispetto al corpo a cui ruota
	
	private double coordinataY ; //coordinate rispetto al corpo a cui ruota
	
	// COSTRUTTORE
	
	public CorpoCeleste ( String _codiceID , double _massa ,double _x , double _y )
	{
		this.codiceID = _codiceID ;
		
		this.massa = _massa ;
		
		this.coordinataX = _x ;
		
		this.coordinataY = _y ;
		
	}

	// METHODS 
	
	public String getCodiceID() 
	{
		return codiceID;
	}

	public void setCodiceID(String codiceID) 
	{
		this.codiceID = codiceID;
	}

	public double getMassa() {
		return massa;
	}

	public void setMassa(double massa) {
		this.massa = massa;
	}
	
	public double getX() 
	{
		return coordinataX;
	}

	public void setX(double x) 
	{
		this.coordinataX = x;
	}

	public double getY() 
	{
		return coordinataY;
	}

	public void setY(double y) 
	{
		this.coordinataY = y;
	}
	

	public double distanzaEstraneo( CorpoCeleste estraneo )
	{
		return Math.sqrt( Math.pow( coordinataX - estraneo.getX(), 2 ) + Math.pow( coordinataY - estraneo.getX() , 2 ));
	}

	public void stampaDati ()
	{
		System.out.println( "Codice univoco: " + codiceID );
		System.out.println("Massa = " + this.massa );
		System.out.println( String.format( "Posizione: ( %.2f ; %.2f )" , this.coordinataX , this.coordinataY ));
	}
	
}
