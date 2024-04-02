
import java.io.FileInputStream;
import java.util.Scanner;

public class showRecord {
	private Scanner read, scnr;
	private String tango, line;
	private int count;
	public showRecord(Scanner read, Scanner scnr) {
		this.read = read;
		this.scnr = scnr;
	}
	public Scanner getScnr() {
		return scnr;
	}
	public Scanner getRead(){
		return read;
	}
	//shown() prints any 1 record to the user
	public void shown() {
		System.out.print("Enter the Last Name: ");
		tango = scnr.next();
		System.out.println("");
		while (read.hasNextLine()) {
			line = read.nextLine();
			if (line.contains("Last Name: " + tango + " ")){
				System.out.println(line);
				++count;
			}
		}
		if (count == 0) {
			System.out.println("Record not found.");
		}
		System.out.println("");
		
	}
	public void print() {
		System.out.println("You chose option 2...");
		System.out.println("");
	}
}
