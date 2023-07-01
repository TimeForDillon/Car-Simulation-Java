package Simulation;
import java.util.ArrayList;
import java.util.Random;

/**
 * A simulation of a commuter station for cars and passengers.
 */
public class Simulation
{
	private static final int MAX = 300;
	private static final int NUMBER_OF_STATIONS = 30;
	private Random randomizer;
	private Station[] station;
	private ArrayList<ArrayList<Car>> carList;
	
	/**
	 * Constructs a Simulation object.
	 */
	public Simulation()
	{
		randomizer = new Random();
		station = new Station[NUMBER_OF_STATIONS];
		carList = new ArrayList<ArrayList<Car>>(NUMBER_OF_STATIONS);
	
		//Create stations and cars, fill station with passengers
		int randomNumber;
		int stationNumber;
		for(int i=0; i<station.length; i++)
		{
			randomNumber=randomizer.nextInt(MAX)+1;
			station[i] = new Station();
			ArrayList<Car> cars = new ArrayList<Car>();
			for(int j=0; j<randomNumber/3; j++)
			{
				cars.add(new Car(i));
			}
			carList.add(cars);
			for(int j=0; j<randomNumber; j++)
			{
				do
				{
					 stationNumber = randomizer.nextInt(station.length);
				}
				while(stationNumber==i);
				station[i].addPassenger(new Passenger(stationNumber));
			}
		}
	}
	
	/**
	 * Executes the simulation a given number of times.
	 * @param numberOfSimulations Number of times to execute simulation.
	 */
	public void simulate(int numberOfSimulations)
	{
		int randomNumber;
		int stationNumber;
		for(int x=0; x<numberOfSimulations; x++)
		{
			// Load Passengers onto Car
			for(int i=0; i<station.length; i++)
			{
				for(int j=0; j<carList.get(i).size(); j++)
				{
					if(!station[i].hasPassengers()) break;
					while(carList.get(i).get(j).roomAvailable()>0 && station[i].hasPassengers())
					{
						carList.get(i).get(j).loadPassenger(station[i].getPassenger());
					}
				}
			}
			
			// Populate more passengers at station.
			for(int i=0; i<station.length; i++)
			{
				randomNumber=randomizer.nextInt(MAX)+1;
				for(int j=0; j<randomNumber/3; j++)
				{
					do
					{
						 stationNumber = randomizer.nextInt(station.length);
					}
					while(stationNumber==i);
					station[i].addPassenger(new Passenger(stationNumber));
				}
			}
			
			//move cars to next station and unload cars
			for(int i=0; i<station.length; i++)
			{
				for(int j=0; j<carList.get(i).size(); j++)
				{
					if(carList.get(i).get(j).getLocation() == station.length-1)
					{
						carList.get(i).get(j).setLocation(0);
					}
					else carList.get(i).get(j).setLocation(carList.get(i).get(j).getLocation()+1);
					carList.get(i).get(j).unloadPassengers();
				}
			}
		}
	}
	
	/**
	 * Returns the object information in a string.
	 */
	public String toString()
	{
		String simText="";
		simText += "Total Passengers: "+Passenger.numberOfPassengers()+"\r"+Car.passengersPerMile();
		return simText;
	}
}
