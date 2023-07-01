package Simulation;
/**
 * A class to test the Simulation class.
 */
public class SimulationTester
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Simulation mySim = new Simulation();
		mySim.simulate(1000);
		System.out.println(mySim.toString());
	}
}
