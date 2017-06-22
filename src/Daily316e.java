/**
 * Dailyprogrammer challenge #316 (easy) - Knights metric
 * 
 * figure out how many moves a chess knight needs to move from 
 * square 0,0 to a given square on an infinite board
 * 
 * 
 * @author Martin Schultz
 *
 */


public class Daily316e {

	static int[][] finalTable = {
			{ 0, 3, 2, 3, 2 },
			{ 3, 2, 1, 2, 3 },
			{ 2, 1, 4, 3, 2 },
			{ 3, 2, 3, 2, 3 }
	};
	
	
	int solve(int x, int y){
		
		// we only work with positive coordinates, since
		// the result will be the same anyway.
		if(x<0) x = -x;
		if(y<0) y = -y;
		
		
		// we make sure x is the biggest number. Again,
		// it won't have any effect on the number of steps.
		if(x<y){
			int z = x;
			x = y;
			y = z;
		}
		
		// we move two steps along the x axis at a time.
		// Leave the final step out to look up the final table
		int steps = (x / 2)-1;
		
		// Move the x\y position according to number of steps.
		x = x - steps - steps;
		for(int l=0; l < steps; l++)
			y += y > 0 ? -1 : 1;
			
		// Check the number of steps left based on the "final table"
		steps += finalTable[x][y];
		
		return steps;
	}
	

	public static void main(String[] args) {

		Daily316e app = new Daily316e();
		System.out.println("4,7 = " + app.solve(4,7));
		System.out.println("-10,5 = " + app.solve(-10,5));
		System.out.println("124, 50 = " + app.solve(124, 50));
		
	}

}
