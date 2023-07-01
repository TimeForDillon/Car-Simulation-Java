package Simulation;
import java.util.ArrayList;

/**
 * a car with room for passengers, a location, and a destination.
 */
public class Car
{
	private static final int MAX_CAP = 3;
	private static double mileCount = 0;
	private static double droppedOff = 0;
	private static int numberOfCars = 0;
	private ArrayList<Passenger> passengers;
	private int location;
	
	/**
	 * Constructs a Car object with a given location and destination.
	 * @param location Current location of car.
	 * @param destination Final destination of car.
	 */
	public Car(int location)
	{
		passengers = new ArrayList<Passenger>(MAX_CAP);
		this.location = location;
		numberOfCars++;
	}
	
	/**
	 * Unloads the passengers from the car if the passengers have reached the destination.
	 * @param destination Location of destination.
	 * @return Passengers leaving car.
	 */
	public void unloadPassengers()
	{
		for(int i=0; i<this.passengers.size(); i++)
		{
			if(this.passengers.get(i).getDestination() == this.location)
			{
				this.passengers.remove(i);
				Car.droppedOff++;
			}
		}
	}
	
	/**
	 * Loads passengers in car.
	 * @param newPassenger New passenger in car.
	 */
	public void loadPassenger(Passenger newPassenger)
	{;
		this.passengers.add(newPassenger);
	}
	
	/**
	 * Retrieves available seats in car.
	 * @return number of available seats in car.
	 */
	public int roomAvailable()
	{
		if(this.passengers.size() >= MAX_CAP)
			return 0;
		else
			return (MAX_CAP - this.passengers.size());
	}
	
	/**
	 * Sets the location of the car.
	 * @param location The location of the car.
	 */
	public void setLocation(int location)
	{
		this.location = location;
		Car.mileCount++;
	}
	
	/**
	 * Retrieves the location of the car.
	 * @return The location of the car.
	 */
	public int getLocation()
	{
		return this.location;
	}
	
	/**
	 * Retrieves the passengers per mile for the car.
	 * @return The passengers per mile for the car.
	 */
	public static String passengersPerMile()
	{
		double ppm = Car.droppedOff/Car.mileCount;
		String output = "Total Cars: " + Car.numberOfCars + "\rCollective Miles Traveled: " 
		+ Car.mileCount/Car.numberOfCars + "\rCollective Passengers Dropped-Off: " + Car.droppedOff + "\rPassengers/Mile = " + ppm;
		return output;
	}
	
	/**
	 * Returns the object information in a string.
	 */
	public String toString()
	{
		String thisCar = "Location: " + this.location + " Passengers: " + this.passengers.size();
		return thisCar;
	}
}
