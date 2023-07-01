package Simulation;
/**
 * Passengers of a car with a current location and final destination.
 */
public class Passenger
{
	private int destination;
	private static int numberOfPassengers = 0;
	
	/**
	 * Constructs a Passenger object with given location and destination
	 * @param location Current location.
	 * @param destination Final destination.
	 */
	public Passenger(int destination)
	{
		this.destination = destination;
		Passenger.numberOfPassengers++;
	}
	
	/**
	 * Retrieves the total number of passengers objects created.
	 * @return Total number of passengers objects created.
	 */
	public static int numberOfPassengers()
	{
		return Passenger.numberOfPassengers;
	}
	
	/**
	 * Sets the final destination of the passenger.
	 * @param destination The final destination of the passenger.
	 */
	public void setDestination(int destination)
	{
		this.destination = destination;
	}
	
	/**
	 * Retrieves the final destination of the passenger.
	 * @return The final destination of the passenger.
	 */
	public int getDestination()
	{
		return this.destination;
	}
	
	/**
	 * Returns the object information in a string.
	 */
	public String toString()
	{
		String thisPassenger = "Destination: " + this.destination;
		return thisPassenger;
	}
}
