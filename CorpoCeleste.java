package it.unibs.fp.arnaldo.Planetarium;

public class CorpoCeleste 
{
	// VARIABLES
	
	private String codiceID ;
	
	private double massa ;

	private double x ;
	
	private double y ;
	
	// COSTRUTTORE
	
	public CorpoCeleste ( String _codiceID , double _massa ,double _x , double _y )
	{
		this.codiceID = _codiceID ;
		
		this.massa = _massa ;
		
		this.x = _x ;
		
		this.y = _y ;
		
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
		return x;
	}

	public void setX(double x) 
	{
		this.x = x;
	}

	public double getY() 
	{
		return y;
	}

	public void setY(double y) 
	{
		this.y = y;
	}
	

	public double distanzaEstraneo( CorpoCeleste estraneo )
	{
		return Math.sqrt( Math.pow( x - estraneo.getX(), 2 ) + Math.pow( y - estraneo.getX() , 2 ));
	}

	public void stampaDati ()
	{
		System.out.println( "Codice univoco: " + codiceID );
		System.out.println("Massa = " + this.massa );
		System.out.println( String.format( "Posizione: ( %.2f ; %.2f )" , this.x , this.y ));
	}
	
}
