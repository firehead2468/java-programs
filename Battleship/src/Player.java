import java.util.Scanner;

public class Player {
	
	String name;
	int shipsLeft;
	
	int[][] defenseGrid = new int[10][10];
	int[][] offenseGrid = new int[10][10];
	
	Ships[] ships = new Ships[5];
	
	Scanner holder = new Scanner(System.in);


	// Constructor method
	public Player(int p) {
		System.out.print("Enter player name: ");
		String playerName = holder.next();
		name = playerName;
		shipsLeft = 5;
		
		for (int x = 0; x < 10; x++)
		{
			for (int y = 0; y < 10; y++)
			{
				defenseGrid[x][y] = 0;
				offenseGrid[x][y] = 0;
			}
		}
		
		setupShip(p);
		
	}


	// Initializes ships with constructor from Ships class
	// Initializes grid with constructor from Grid class
	public void initShip() {
		
		// Cycles through 5 ships and assigns names and space values to them
		for (int i = 4; i >= 0; i--)
		{
			ships[i] = new Ships();
			ships[i].shipSpaces = i + 1;
			 
			switch (i) {
				case 0:
					ships[i].shipName = "patrol boat";
					break;
				case 1:
					ships[i].shipName = "frigate";
					break;
				case 2:
					ships[i].shipName = "cruiser";
					break;
				case 3:
					ships[i].shipName = "battleship";
					break;
				case 4:
					ships[i].shipName = "aircraft carrier";
					break;
			}
		}
	}
	
	
	// Gets position of ship from user
	public void setShip(int i) {
		System.out.println("Setting " + ships[i].shipName + "...");
		
		// Set X
		System.out.print("X: ");
		int tempY = holder.nextInt();
		ships[i].shipY = tempY - 1;
		
		// Set Y
		System.out.print("Y: ");
		int tempX = holder.nextInt();
		ships[i].shipX = tempX - 1;

		// Allow option to make ship vertical
		System.out.print("Make vertical? (y/n): ");
		String tempVert = holder.next();
		if (tempVert.equalsIgnoreCase("y"))
			ships[i].vertical = 1;
		
		// Change grid to reflect new position of ship
		for (int z = 0; z < ships[i].shipSpaces; z++)
		{
			if (ships[i].vertical == 1) 
			{
				defenseGrid[ships[i].shipX + z][ships[i].shipY] = i + 1;
			}else{
				defenseGrid[ships[i].shipX][ships[i].shipY + z] = i + 1;
			}
			
		}
		
		// Print grid
		printDefenseGrid();
	}
	

	// Prints player's defensive grid
	public  void printDefenseGrid() {
		for (int x = 0; x < 10; x++) 
		{
			for (int y = 0; y < 10; y++) 
			{
				System.out.print(defenseGrid[x][y]);
				System.out.print(" | ");
			}
			
			System.out.println("\n———————————————————————————————————————");
		}
	}
	
	// Prints player's offensive grid
	public void printOffenseGrid() {
		for (int x = 0; x < 10; x++) 
		{
			for (int y = 0; y < 10; y++) 
			{
				System.out.print(offenseGrid[x][y]);
				System.out.print(" | ");
			}
			
			System.out.println("\n———————————————————————————————————————");
		}
	}
	
		
	public void setupShip(int p) {
		System.out.println("Setting Ships (" + name + "'s turn):");
		
		// Initialize ships
		initShip();
		
		// Set ships positions and orientations
		for (int i = 4; i >=0 ; i--)
		{
			setShip(i);
			
		}
		
		if (p == 0) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
					+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
					+ "Your ships are now locked. "
					+ "Please pass the device to player 2.");
		}else{
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
					+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
					+ "All ships are now locked. "
					+ "Please pass the device to player 1."
					+ "\nPlayer 1, hit enter to begin the game.");
			
			Scanner temp = new Scanner(System.in);
			String gameEnter = temp.nextLine();
			if (gameEnter.equals('\n') == false)
				System.out.println("Let the game begin!");
				
		}
	}
	
}
