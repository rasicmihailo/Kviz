import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.*;

public class Klijent {

	
	private Kviz kviz;
	
	public Klijent(String host, String port, String service) throws MalformedURLException, RemoteException, NotBoundException {
		
		kviz = (Kviz)Naming.lookup("rmi://" + host + ":" + port + "/" + service);
		
		kviz.pocetak();
		
		for(int i = 0; i<3; i++) {
			
			System.out.println(kviz.vratiPitanje().vratiTekst());
			
			Scanner scanIn = new Scanner(System.in);
			String odgovor = scanIn.nextLine();
			
			kviz.odgovori(odgovor);
			
		}
		
		System.out.println("\nOsvojen broj poena: " + kviz.vratiBrojPoena());
	}
	
	
	public static void main(String[] args) {
		
		String host = args[0];
		String port = args[1];
		String service = args[2];
		
		try {
			
			new Klijent(host, port, service);			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

}