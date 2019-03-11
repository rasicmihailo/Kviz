import java.net.MalformedURLException; 
import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.rmi.registry.*; 


public class Server {


	public Server(String host, String port, String service) throws RemoteException, MalformedURLException {
	
		Kviz kviz = null;
		
		kviz = new KvizImpl();
		
		LocateRegistry.createRegistry(Integer.parseInt(port));
		
		Naming.rebind("rmi://" + host + ":" + port + "/" + service, kviz);
		
	}
	
	
	public static void main(String[] args) {

		String host = args[0];
		String port = args[1];
		String service = args[2];
		
		try {
			new Server(host, port, service);
			System.out.println("Server pokrenut");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
