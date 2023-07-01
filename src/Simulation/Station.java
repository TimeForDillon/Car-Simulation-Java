package Simulation;
import java.util.ArrayList;

/**
 * A commuter station with cars and passengers.
 */
public class Station
{
	private static int numberOfStations = 0;
	private ArrayList<Passenger> passengers;
	private int location;
	
	/**
	 * Constructs a Station object with a location mile number.
	 */
	public Station()
	{
		this.passengers = new ArrayList<Passenger>();
		this.location = Station.numberOfStations;
		Station.numberOfStations++;
	}
	
	/**
	 * Retrieves the total number of Station objects.
	 * @return The total number of Station objects.
	 */
	public static int getNumberOfStations()
	{
		return Station.numberOfStations;
	}
	
	/**
	 * Retrieves the current location of the station.
	 * @return The current location of the station.
	 */
	public int getLocation()
	{
		return this.location;
	}
	
	/**
	 * Adds a passenger to the station.
	 * @param newPassenger A passenger to add to the station.
	 */
	public void addPassenger(Passenger newPassenger)
	{
		this.passengers.add(newPassenger);
	}
	
	/**
	 * Retrieves a passengers in the station.
	 * @return A Passenger in the station. 
	 */
	public Passenger getPassenger()
	{
		Passenger newPassenger = this.passengers.get(0);
		this.passengers.remove(0);
		return newPassenger;
	}
	
	/**
	 * Returns true if Station has passengers. 
	 * @return True if station has passengers.
	 */
	public boolean hasPassengers()
	{
		return this.passengers.size()>0;
	}
	
	/**
	 * Returns the object information in a string.
	 */
	public String toString()
	{
		String thisStation = "";
		for(int i=0; i<this.passengers.size(); i++)
		{
			thisStation += "Passenger "+i+": " + this.passengers.get(i).toString() + "\r";
		}
		return thisStation;
	}
}
