// Jacob Conrad, Practice 5, April 13, 2020, The MovementHolder class is a class to hold an integer representing a different type of movement. 1 is move randomly, 2 is follow the leader, and 3 is do nothing

public class MovementHolder {

	private int movement;

	// MovementHolder constructor, initializes movement value
	public MovementHolder(int movement) {
		this.movement = movement;
	}
	
	public int getMovement() {
		return movement;
	}
	
	public void setMovement(int movement) {
		this.movement = movement;
	}
}
