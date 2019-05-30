package view;

public class Location
{
    //Implement the Location class here
    public static final int UNPLAYED = 0;
    public static final int PLAYED = 1;
    
    
    public int stat;
    
    
    @Override
	public String toString() {
		if(stat == 0) {
			return "~";
		} else {
			return "X";
		}
	}
    
	public Location()
    {
        stat = UNPLAYED;
    }
    public boolean checkHit()
    {
        return stat == PLAYED;
    }
    // Was this location a miss?
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}

	public boolean isUnplayed() {
		// TODO Auto-generated method stub
		if(getStat() == 0)
			return true;
		return false;
	}
	
    
}