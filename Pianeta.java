package it.unibs.fp.arnaldo.Planetarium;

import java.util.ArrayList;

public class Pianeta extends CorpoCeleste {

	
	private ArrayList<Luna> lune = new ArrayList<Luna>();
	
	
	
	public Pianeta(String _codiceID, double _massa, double _x, double _y) {
		super(_codiceID, _massa, _x, _y);
		
	}
	
	
	public ArrayList<Luna> getLune() {
		return lune;
	}


	public void setLune(ArrayList<Luna> lune) {
		this.lune = lune;
	}


	public void addLuna(Luna nuovaLuna) {
		
		if(lune.contains(nuovaLuna)) {
			System.out.println("Luna già esistente nel orbita del pianeta\n"); //controllo se esiste la luna
		}else lune.add(nuovaLuna);
	}
	
	public void remvLuna(Luna oldLuna) {
		
		if(lune.contains(oldLuna)) {
			System.out.println("Luna non trovata\n"); //controllo se esiste la luna da rimuovere
		}else lune.remove(oldLuna);
	}
}
