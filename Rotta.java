package it.unibs.fp.arnaldo.Planetarium;
import it.unibs.fp.mylib.InputDati;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

/**
* @author christian garcia
*
*/

public class Rotta {
		
	//private  ArrayList<Stella> listastelle = new ArrayList<Stella>();
	
	public void calcola(ArrayList<Stella> list) {
		//variabili usate nel blocco della partenza
		int pi=-1,pl=-1,posPianetaLuna=-1;// pi= posizione pianeta partenza nel array,pf= posizione luna di partenza
										//posPianetaLuna=posizione del pianeta a cui appartiene la luna(in caso di partenza da una luna)
		
		//variabili usate nel blocco arrivo
		int pi1=-1,posPianetaLunaArr=-1,posLunaArr=-1;//pi1=posizione pianeta arrivo,posPianetaLunaArr=posizione del pianeta della luna di arrivo(in caso di arrivo su una luna)
										       // posLunaArr=posizione della luna di arrivo
		
		 //altre variabili
		boolean flag=true;// variabile per determinare uqando uscire dai cicli while
		String p = null;// stringa pianeta partenza,in caso si selezioni un pianeta come partenza
		String l = null;//stringa luna partenza,in caso si selezioni una luna come partenza
		String ap;// stringa per determinare il pianeta di arrivo
		String la;//stringa per luna di arrivo
		double distanzaPercorsa=0; // variabile della distanza totale percorsa
		
		//variabili in cui si immetterano, a seceonda dei corpi celesti di partenza, rispettivamente le rotte di partenza e quella di arrivo
		String start;
		String finish = null;
		//Array per le coordinate
		ArrayList<Double> coordX=new ArrayList<Double>();// memorizzo le coordinate X
		
		ArrayList<Double> coordY=new ArrayList<Double>();//memorizzo le coordinate Y
		
		if(list.isEmpty()) {
			
			System.out.println("Sistema vuoto, inserire dati");// controllo se la lista di stelle è vuota
		}else {
			//scelta sistema in base alla stella
			System.out.println("Scegli la il sistema in base alla stella presente");
			for(int i=0;i<list.size();i++) {
				System.out.println(" "+ i +1 +": Sistema " +list.get(i).getCodiceID());//stampo lista stelle esistenti
				
			}
		int scelta =InputDati.leggiIntero("",0,list.size());
		//nel list.get metto scelta-1 perchè ho fatto partire la lista da 1 e non da zero, cosi qualunque numero scegliera dovra essere un' unità inferiore
		
		//inizio blocco che controlla se si deve partire da un pianeta o luna
		String partenza=InputDati.leggiStringaNonVuota("Scegliere se partire da una luna o da un pianeta:").toLowerCase().trim();
		
		
		//blocco codice in caso di partenza da pianeta
		
		if (partenza.equals("pianeta")) {
			//si, si poteva fare acnhe con una selezione numerica, ma ho voluto allenarmi un po sulle stringhe, se vuoi puoi provare a modificarlo
			//con i numeri al posto delle stringhe :D
				while(flag) {
			for(int i=0;i<list.get(scelta-1).getPianeti().size();i++) {
				System.out.println("lista pianeti disponibili:\n " + i+1+list.get(scelta-1).getPianeti().get(i).getCodiceID());
				//sttampo lista pianeta disponibili
			}
			
			
			 p=InputDati.leggiStringaNonVuota("Scrivi il pianeta di partenza:").toLowerCase().trim();
			//ciclo for per prendere la posizione in base alla stringa
			for(pi=0; pi<list.get(scelta-1).getPianeti().size() && list.get(scelta-1).getPianeti().get(pi).getCodiceID().equals(p)==false;pi++); 
				//controllo esistenza del pianeta
					if(pi==list.get(scelta-1).getPianeti().size()) {
						System.out.println("Pianeta non trovato" );
					}else { 
						flag=false;
						start=list.get(scelta-1).getPianeti().get(pi).getCodiceID();
						coordX.add(list.get(scelta-1).getPianeti().get(pi).getX());
						coordY.add(list.get(scelta-1).getPianeti().get(pi).getY());
						}
			
				}//fine blocco pianeta
				
				//blocco in caso di luna di partenza
		}else if(partenza.equals("luna")) {
			flag=true;
			while(flag) {
			for(int i=0;i<list.get(scelta-1).getPianeti().size();i++) {
				for(int j=0;j< list.get(scelta-1).getPianeti().get(i).getLune().size();j++)
				System.out.println("lista lune disponibili:\n "  +list.get(scelta-1).getPianeti().get(i).getLune().get(j).getCodiceID());
			}
			
				 l=InputDati.leggiStringaNonVuota("Scrivi la luna di partenza").toLowerCase().trim();
				 boolean trovato=false;
				 //ciclo per trovare il pianeta al cuale appartiene la luna di partenza, e la posizione della luna stessa
				for(posPianetaLuna=0; posPianetaLuna < list.get(scelta-1).getPianeti().size() && trovato==false;posPianetaLuna++) {	
				 for(pl=0; pl<list.get(scelta-1).getPianeti().get(posPianetaLuna).getLune().size() ;pl++);//ciclo for per prendere la posizione in base alla stringa
					if(list.get(scelta-1).getPianeti().get(posPianetaLuna).getLune().get(pl).getCodiceID().equals(l)) {
							trovato=true;
							break;
					}
				}
				if(pl==list.get(scelta-1).getPianeti().get(posPianetaLunaArr).getLune().size()) {
					System.out.println("Luna non trovata" );//controllo esistenza della luna
				}else {
					flag=false;
					start=list.get(scelta-1).getPianeti().get(posPianetaLuna).getLune().get(pl).getCodiceID() + " > " + list.get(scelta-1).getPianeti().get(posPianetaLuna).getCodiceID();
					coordX.add(list.get(scelta-1).getPianeti().get(posPianetaLuna).getLune().get(pl).getX());//coordiante luna
					coordY.add(list.get(scelta-1).getPianeti().get(posPianetaLuna).getLune().get(pl).getY());
					coordX.add(list.get(scelta-1).getPianeti().get(posPianetaLuna).getX());//coordinate pianeta 
					coordY.add(list.get(scelta-1).getPianeti().get(posPianetaLuna).getY());
				}
				
				
			}
		}
		//fine blocco partenza
		
		//inizio blocco scelta destinazione
		String arrivo=InputDati.leggiStringaNonVuota("Scegli se il corpo celeste di destinazione dev'essere un pianeta o una luna diversa da quella di partenza").toLowerCase().trim();
		if(arrivo.equals("pianeta")) {
			flag=true;
			
			while(flag) {
				for(int i=0;i<list.get(scelta-1).getPianeti().size();i++) {
					if(list.get(scelta-1).getPianeti().get(i).getCodiceID().equals(p)) { //controllo che il pianeta di partenza non compaia 
					}else System.out.println("lista pianeti disponibili:\n " + i+1+list.get(scelta-1).getPianeti().get(i).getCodiceID());
				//stampo lista pianeta disponibili
			    }
				
				do {
				 ap=InputDati.leggiStringaNonVuota("Scrivi il pianeta di arrivo:").toLowerCase();// controllo diversita del nome in caso si partisse da un pianeta
				}while(ap.equals(p));
					
				//ciclo for per prendere la posizione in base alla stringa
				for(pi1=0; pi1<list.get(scelta-1).getPianeti().size() && !(list.get(scelta-1).getPianeti().get(pi1).getCodiceID().equals(ap));pi1++);
				
				//controllo esistenza del pianeta
				if(pi1==list.get(scelta-1).getPianeti().size()) {
					System.out.println("Pianeta non trovato" );
				}else {
					flag=false;
					
							//controllo (in caso di partenza da una luna) se il pianeta di destinazione  sia quello in cui orbita la luna
							//in caso di partenza da una dell sue lune le coordiante sono già presenti nel vettore
						if(posPianetaLuna==pi1) {
							
							finish=list.get(scelta-1).getPianeti().get(posPianetaLuna).getLune().get(pl).getCodiceID() + " > " + list.get(scelta-1).getPianeti().get(posPianetaLuna).getCodiceID();
						}else {
							finish=" > " + list.get(scelta-1).getCodiceID() + " > " + list.get(scelta-1).getPianeti().get(pi1).getCodiceID();
							coordX.add(list.get(scelta-1).getX());//coordinate stella
							coordY.add(list.get(scelta-1).getY());
							coordX.add(list.get(scelta-1).getPianeti().get(pi1).getX());//coordinate pianeta
							coordY.add(list.get(scelta-1).getPianeti().get(pi1).getY());
						}
						
					}
				
			}
		}else if(arrivo.equals("luna")) {
			flag=true;
			//stampo lune disponibili escludendo la luna in partenza in caso sia presente
			while(flag) {
			 for(int i=0;i<list.get(scelta-1).getPianeti().size();i++) {
				for(int j=0;j< list.get(scelta-1).getPianeti().get(i).getLune().size();j++)
				
					if(list.get(scelta-1).getPianeti().get(i).getLune().get(j).getCodiceID().equals(l)==false)
				System.out.println("lista lune disponibili:\n "  +list.get(scelta-1).getPianeti().get(i).getLune().get(j).getCodiceID());
			 }
			 do {
				 la=InputDati.leggiStringaNonVuota("Scrivi luna di arrivo:").toLowerCase();// controllo diversità luna in caso si selezioni luna come partenza
				}while(la.equals(l));
			 
			     boolean trovato=false;
			     //ciclo per prendere le posizioni del pianeta di apartenenza e la posizione della luna
			   for(posPianetaLunaArr=0;posPianetaLunaArr <list.get(scelta-1).getPianeti().size() && trovato==false;posPianetaLunaArr++) {
					for(posLunaArr=0;posLunaArr < list.get(scelta-1).getPianeti().get(posPianetaLunaArr).getLune().size();posLunaArr++)
						if(list.get(scelta-1).getPianeti().get(posPianetaLunaArr).getLune().get(posLunaArr).getCodiceID().equals(la)) {
							trovato=true;
							break;
						}
			   }
			   
			   if(posLunaArr==list.get(scelta-1).getPianeti().get(posPianetaLunaArr).getLune().size()) {
				   System.out.println("luna non trovata");
			   }else {
				   flag=false;
				   //controllo che il pianeta della luna di arrivo sia quello di partenza oppure no
				  if(posPianetaLunaArr==pi) {
					  finish= "> " +list.get(scelta-1).getPianeti().get(posPianetaLunaArr).getLune().get(posLunaArr).getCodiceID();
					  
				  }else {
					  finish=" > "+list.get(scelta-1).getCodiceID() + " > " + list.get(scelta-1).getPianeti().get(posPianetaLunaArr).getCodiceID() + " > "+list.get(scelta-1).getPianeti().get(posPianetaLunaArr).getLune().get(posLunaArr).getCodiceID();
				  }
			   }
			}	
			   
		}
		
		// controllare se il pianeta di partenza e quello di arrivo coincidono confrontando  la posizione
		
			//stampo la rotta in base alle stringhe che avrò (si spera) ottenuto
		System.out.println(partenza + finish);
		
			//calcolo la rotta con le coordinate presenti nel arraylist delle coordinate, aggiunte a seconda di cosa si selezionava come partenza e arrivo
		
			
		}
			
		
	}
	
	private double distanzaPercorsa(int x1,int y1,int x2,int y2) {
		double d=Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
		return d;
	}
}
