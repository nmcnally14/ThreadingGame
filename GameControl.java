/**
 * 
 */
package threadingChallenge;

import java.util.Scanner;

/**
 * @author Nicola
 *
 */
public class GameControl {
	
	public static final int gameLength = 30;

	/**
	 * 
	 */
	public GameControl() {
		// TODO Auto-generated constructor stub
	}
	
	//used to control the length of game and when to naturally quit the timer thread

	/**
	 * Method controls the game
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Count of " +gameLength+ "secs game ");
		System.out.println("Press any key and enter to start .. then estimate when "+gameLength+ " secs have elapsed");
		sc.nextLine();
		
		System.out.println("Start countring ...");
		System.out.println("Hit any key and enter when you think time is up");
		
		//here now, so start timer
		Timer timer = new Timer();
		Thread thread = new Thread(timer);
		thread.start();
		
		//all done - user has entered any key and hit enter
		sc.nextLine();
		
		//check if timer thread is still alive
		if (thread.isAlive())	{
			//too early, late or on the money!
			if (timer.getCurrentCount()<gameLength)	{
				System.out.println("Too early : that was "+timer.getCurrentCount() + " secs");
			} else if (timer.getCurrentCount()>gameLength)	{
				System.out.println("Too late : that was "+timer.getCurrentCount() + " secs");
			} else {
				System.out.println("Nice one you got it exactly right!");
			}
			//stop the thread
			thread.interrupt();
		} else	{
			//thread has died so way too late
			System.out.println("Way too late! You miised the target by at least double");
			thread.interrupt();
		}
		
		System.out.println("Game over!");
		
		//tidy the house!
		sc.close();
		
	}

}
