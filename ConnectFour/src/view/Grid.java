package view;

public class Grid
{
    // Write your Grid class here
    private Location[][] grid;
    
    // Constants for number of rows and columns.
    public static final int NUM_ROWS = 7;
    public static final int NUM_COLS = 6;
    
    // Create a new Grid. Initialize each Location in the grid
    // to be a new Location object.
    public Grid()
    {
        grid = new Location[NUM_ROWS][NUM_COLS];
        for(int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                Location elem = new Location();
                grid[row][col] = elem;
            }
        }
    }
    
    public void setPiece(int r,int c) {
    	grid[r][c].setStat(1);
    }
    
    public boolean addPiece(int x) {
    	for( int i = 0; i < grid.length;i++) {
    		if(grid[i][x].isUnplayed()) {
    			setPiece(i-1,x);
    			return true;
    		}
    			
    	}
    	return false;
    }
    public void printStatus()
    {
        
        for(int row = 0; row < NUM_ROWS; row++)
        {
            
            for(int col = 0; col < NUM_COLS; col++)
            {
                if(grid[row][col].isUnplayed())
                {
                    System.out.print(" -");//" -" signifies unguessed
                }
                else 
                {
                    System.out.print(" O");//missed
                }
                
               
            }
            System.out.println("");
        }
       
    }
    
}