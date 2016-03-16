import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuitarNotes {

	public GuitarNotes() throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		SongConstructor SevenNationArmy = new SongConstructor();
		String userInput;
		double speed;

		int selection = 1;

		while (selection != 0) {

			System.out.println("1)Add song part 2)Show the notes and times 3)Change Speed 4)Save the outcome to your disk 0)Exit");
			selection = scan.nextInt();

			if (selection == 1) {
				System.out.println("Enter file name");
				userInput = scan.next();
				SevenNationArmy.addSongPart(userInput);
			}

			else if (selection == 2)
				System.out.println(SevenNationArmy.output());
			
			else if (selection == 3) {
				System.out.println("Please enter desired speed factor");
				speed = scan.nextDouble();
				SevenNationArmy.changeSpeed(speed);
			}

			else if (selection == 4)
				SevenNationArmy.saveToDrive("SevenNationArmyTest.csv");
		}

		System.out.println("Goodbye and please use stringmeister for best results");

	}

}
