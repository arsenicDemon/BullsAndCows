import java.util.Scanner;

public class Game {
	
	Scanner input = new Scanner(System.in);
	String key = "blue";
	int level = key.length();

	public Game() {
		System.out.println("Welcome to Bulls and Cows.\n");
		System.out.println("Difficulty level = " + level);
		System.out.printf("Can you guess the %d lettered isogram I'm thinking of..\n\n", level);
	}
	
	public void playGame() {
		do {
			
			System.out.println("Enter your guesses.");
			
			for(int i = (level*2) - 1; i >= 0; i--) {
				String guess = enterGuess();
				if(guess == "0")
					break;
				else {
					System.out.println("You guessed - " + guess);
					System.out.println("Bulls = " + bulls(guess) + ", Cows = " + cows(guess));
					if(bulls(guess) == level) {
						System.out.println("YOU WIN!!!  :)\n");
						break;
					}
					System.out.println("(" + i + " turn(s) left.)\n");
					if(i == 0)
						System.out.println("YOU LOSE!!  :(");
				}
					
			}
			
		}
		while(playAgain() == true);
	}
	
	public String enterGuess() {
		String guess = input.next();
		if(guess.length() != level) {
			System.out.println("ERROR! Guess must be " + level + " letters long.");
			return "0";
		}
			
		else
			return guess;
	}
	
	public int bulls(String guess) {
		int bullCount = 0;
		for(int i = 0; i < level; i++) {
			if(guess.charAt(i) == key.charAt(i))
				bullCount++;
		}
		return bullCount;
	}
	
	public int cows(String guess) {
		int cowCount = 0;
		for(int i = 0; i < level; i++) {
			for(int j = 0; j < level; j++) {
				if(j == i)
					continue;
				if(guess.charAt(i) == key.charAt(j))
					cowCount++;
			}
		}
		return cowCount;
	}
	
	public boolean playAgain() {
		System.out.println("Press 'Y' to play again or any key to quit.");
		char response = input.next().charAt(0);
		if(response != 'Y' && response != 'y')
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game obj = new Game();
		obj.playGame();
	}

}
// hello
