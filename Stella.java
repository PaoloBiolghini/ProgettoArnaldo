package it.unibs.fp.arnaldo.Planetarium;

/**
* @author christian garcia
*
*/

import java.util.ArrayList;

public class Stella extends CorpoCeleste {

	private ArrayList<Pianeta> pianeti = new ArrayList<Pianeta>();
	public Stella(String _codiceID, double _massa, double _x, double _y) {
		super(_codiceID, _massa, _x, _y);
		
	}
	public ArrayList<Pianeta> getPianeti() {
		return pianeti;
	}
	public void setPianeti(ArrayList<Pianeta> pianeti) {
		this.pianeti = pianeti;
	}
	//aggiunta pianeta
	public void addPianeta(Pianeta nuovoPianeta) {
		
		if(pianeti.contains(nuovoPianeta)) {
			System.out.println("Pianeta già esistente nel orbita della stella\n"); //controllo se esiste il pianeta
		}else pianeti.add(nuovoPianeta);
	}
	
	//rimozione pianeta
	
	public void remvPianeta(Pianeta oldPianeta) {
		if(pianeti.contains(oldPianeta)) {
			System.out.println("Pianeta già esistente nel orbita della stella\n"); //controllo se esiste il pianeta
		}else pianeti.add(oldPianeta);
	}
	
	
	}
	
	

