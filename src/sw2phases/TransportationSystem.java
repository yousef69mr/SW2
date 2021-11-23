package sw2phases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TransportationSystem {
	private String systemName;
	private Administrator admin;
	private static TransportationSystem uniqueSystem;
	private Set<Users> users;
	
	private ArrayList<Driver> drivers;
	private ArrayList<Client> clients;
	private ArrayList<Ride> rides;
	
	private ArrayList<Users> suspended;
	private ArrayList<Users> requests;
	private ArrayList<Users> confirmed;
	private ArrayList<Users> deleted;
	
	public TransportationSystem(String n){
		
		setName(n);
		admin =new Administrator(this);
		users = new HashSet<Users>();
		drivers = new ArrayList<Driver>();
		clients = new ArrayList<Client>();
		rides = new ArrayList<Ride>();
		suspended=new ArrayList<Users>();
		requests=new ArrayList<Users>();
		confirmed=new ArrayList<Users>();
		deleted=new ArrayList<Users>();
		
	}
	
	public static TransportationSystem getInstance(String name) {
		if (uniqueSystem == null) {
			uniqueSystem = new TransportationSystem(name);
		}
		return uniqueSystem;
	}

	
	//relation with Users class
	public void addUser(Users a) {
		
		users.add(a);
		confirmed.add(a);
		
		a.setSystem(this);
	}
	public void removeUser(Users a) {
		
		users.remove(a);
		deleted.add(a);
		
		a.setSystem(null);
	}
	////////////	
	
	//relation with Ride  class
	public void addRide(Ride r) {
		rides.add(r);
		r.setRideOwner(this);
	}
	public void removeRide(Ride r) {
		rides.remove(r);
		r.setRideOwner(null);
	}
        
	
	Administrator getAdmin() {
		return this.admin;
	}
	
	void setName(String n) {
		
		this.systemName=n;
		
	}
	
	 
	String getName() {
		return this.systemName;
	}
	
	ArrayList<Driver> getAllDrivers(){
		return drivers;
	}
	
	ArrayList<Users> getAllRequests(){
		return requests;
	}
	
	ArrayList<Users> getAllConfirmed(){
		return confirmed;
	}
	
	ArrayList<Users> getAllSuspended(){
		return suspended;
	}
	
	ArrayList<Ride> getAllRides(){
		return rides;
	}
                       ArrayList<Client> getAllClients(){
                           return clients;
                       }
                        Set<Users> getAllUsers(){
                           return users;
                       }
                        
	void displayDrivers() {
		for(int i=0;i<drivers.size();i++) {
			drivers.get(i).DisplayData();
		}
	}
		
		ArrayList<Ride> getRideSourceMatchesFavouriteAreaOfDriver(Driver drive,ArrayList<Ride> ride){
			ArrayList<Ride> selectedRides=new ArrayList<Ride>();
			
			for(int i=0;i<rides.size();i++) {
				if(drive.isFavourite(ride.get(i), drive.getFavouriteAreas())) {
					selectedRides.add(ride.get(i));
				}
			}
			return selectedRides;
		}
	
}