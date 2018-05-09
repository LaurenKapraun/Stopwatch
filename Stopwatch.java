import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

/** 
 * This class has a user hit enter to start and stop the stopwatch.
 * 
 * When they hit enter to stop, the number of seconds and milliseconds is displayed.
 * 
 * @author Lauren Kapraun
 *
 */

public class Stopwatch
{
	private int milliseconds;
	private Timer timer; 
	
	/**
	 * Default Stopwatch Constructor
	 * 
	 */
	public Stopwatch() {
		super();
		
		//Set milliseconds to 0
		milliseconds = 0;
		
		//Create a timer to track the time
		timer = new Timer(1, new TimeListener()); 
	}
	
	/**
	 * returnMilliseconds
	 * 
	 * @return milliseconds Time between start and stop in milliseconds
	 */
	public int returnMilliseconds() {
		return milliseconds;
	}
	
	/**
	 * Method to start timer
	 * 
	 */
	public void start(){
		timer.start();
	}

	/**
	 * Method to stop timer
	 * 
	 */
	public void stop(){
		timer.stop();
	}
	
	/**
	 * Main Method
	 * 
	 * Creates new stopwatch
	 * Creates new Scanner for the user to start/stop the watch
	 * Prints out time in seconds & milliseconds to console
	 * 
	 */
	public static void main(String[] args) {
		Stopwatch stopwatch = new Stopwatch();
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Hit enter to start the clock");
		kb.nextLine();
		stopwatch.start();
		
		System.out.print("Hit enter to stop the clock");
		kb.nextLine();
		stopwatch.stop();
		
		System.out.println("\n" + (stopwatch.milliseconds/1000.0) + " seconds\n" +
				stopwatch.milliseconds + " milliseconds");
		
		kb.close();
	}

	/**
	 * TimeListener Class
	 * 
	 * Increments the milliseconds while stopwatch is active
	 * 
	 */
	public class TimeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			milliseconds++;	
		}
	}
}