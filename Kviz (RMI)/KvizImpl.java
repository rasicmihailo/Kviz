import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.lang.Object;

public class KvizImpl extends UnicastRemoteObject implements Kviz {
	
	private Hashtable<Integer, Pitanje> pitanja;
	
	private int brPoena;
	
	private int trenutnoPitanje;
	
	public KvizImpl() throws RemoteException{
	
	}
	
	
	@Override
	public void pocetak() throws RemoteException {
	
		this.pitanja = new Hashtable<Integer, Pitanje>();
		
		pitanja.put(1, new PitanjeImpl("1+1=", "2", "3", "4", "a"));
		pitanja.put(2, new PitanjeImpl("1+2=", "2", "3", "4", "b"));
		pitanja.put(3, new PitanjeImpl("1+3=", "2", "3", "4", "c"));
		
		this.brPoena = 0;
		
		this.trenutnoPitanje = 0;
	
	}
	
	@Override
	public Pitanje vratiPitanje() throws RemoteException {
	
		trenutnoPitanje++;
		
		return (PitanjeImpl)pitanja.get(trenutnoPitanje);
	
	}
	@Override
	public void odgovori(String odg) throws RemoteException {
		
		if (((PitanjeImpl)pitanja.get(trenutnoPitanje)).tacanOdg.equals(odg))
			this.brPoena ++;
		
	}
	
	
	@Override
	public int vratiBrojPoena() throws RemoteException {
		
		return this.brPoena;
		
	}
	
}