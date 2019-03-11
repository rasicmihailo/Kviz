import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PitanjeImpl extends UnicastRemoteObject implements Pitanje {
	
	private String tekst;
	private String odgA;
	private String odgB;
	private String odgC;
	public String tacanOdg;
	
	public PitanjeImpl(String tekst, String a, String b, String c, String tacan) throws RemoteException {
		
		this.tekst = tekst;
		this.odgA = a;
		this.odgB = b;
		this.odgC = c;
		this.tacanOdg = tacan;
	
	}
	
	
	@Override
	public String vratiTekst() throws RemoteException {
		
		return "Pitanje: " + this.tekst + "\na)" + this.odgA + "\nb)" + this.odgB + "\nc)" + this.odgC;
		
	}
	
}