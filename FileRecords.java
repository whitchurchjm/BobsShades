import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecords {

	public static void main(String[] args) throws IOException{
		Scanner scnr = new Scanner(System.in);
		//allows user to access file_records in various ways
		String fileName = "file_records.txt";
		File fr = new File(fileName);
		FileWriter fw = new FileWriter(fileName,true);
		Scanner scanFile = new Scanner(fileName);
		FileInputStream reader = new FileInputStream("file_records.txt");
		Scanner read = new Scanner(reader);
		//used to delete a record 
		File tempFile = new File("temp.txt");
		BufferedReader fileReader = new BufferedReader(new FileReader(fr));
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(tempFile));
		
		int records = 0;
		int createRec = 0;
		int input = -1;
		final int one = 1;
		final int two = 2;
		final int three = 3;
		final int four = 4;
		final int five = 5;
		int option = 0;
		try {
		while (option == 0) {
			//Prints menu
			intro.print();
			//ensures user enters valid input
			try {
				input = scnr.nextInt();				
				if ((input < 0) || (input > 5)) {
					int hi = 10 / 0;
					System.out.println(hi);
				}
			}
			catch(ArithmeticException ex) {
				System.out.println("Error: Number was not 1-5.");
				System.out.println("Terminating the program...");
				System.exit(0);
			}
			catch (Exception e) {
				System.out.println("Error: Number 1-5 must be entered.");
				System.exit(0);
			}
			if (input == one){
				//prevents program from breaking
				try {
					if (records >= 1) {
						int hi = 10 / 0;
						System.out.println(hi);
					}
				}
				catch(ArithmeticException ex) {
					System.out.println("Exit to create more records.");
					System.out.println("Terminating the program...");
					break;
				}
				createRecord create = new createRecord(scnr,fw);
				create.getInfo();
				create.storeInfo();
				createRec++;
			}
			else if (input == two) {
				showRecord show = new showRecord(read, scnr);
				show.print();
				show.shown();
				read = new Scanner(fr);
			}
			else if (input == three) {
				//prevents program from breaking
				if (records > 0) {
					try {
						int hi = 10 / 0;
						System.out.println(hi);
					}
					catch(ArithmeticException ex) {
						System.out.println("Only one record can be deleted per run.");
						System.out.println("Terminating the program...");
						break;
					}
				}
				//prevents user from losing unsaved changes
				if (createRec > 0) {
					try {
						int hi = 10 / 0;
						System.out.println(hi);
					}
					catch(ArithmeticException ex) {
						System.out.println("Continuing will not save unsaved records.");
						System.out.println("To continue, type Yes.");
						System.out.println("To exit and save, type No.");
						String continue_ = scnr.next();
						if (continue_.equals("No")) {
							System.out.println("Records saved.");
							break;
						}
						
					}
				}
				
				
			}
			
			else if (input == five) {
				ExitLoop.print();
				break;
			}
			System.out.println("Enter next option: ");
		}
		}
		catch(IOException exe) {
			
		}
		//fw.flush();
		fw.close();
	}
}
