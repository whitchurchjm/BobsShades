
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class createRecord {
	private int id, phoneNumber;
	private String firstName, lastName, address;
	private FileWriter fw;
	private Scanner scnr;

	public createRecord(Scanner scnr, FileWriter fw) {
		this.scnr = scnr;
		this.fw = fw;
	}

	public Scanner getScanner() {
		return scnr;
	}

	public FileWriter getFileWriter() {
		return fw;
	}

	// getInfo gets input from user for new record
	public void getInfo() {
		System.out.println("You chose option 1...");
		System.out.println("");
		System.out.print("Enter the Customer ID: ");
		try {
			id = scnr.nextInt();
		} catch (Exception e) {
			System.out.println("Error: integer not entered.");
			System.exit(0);
		}
		System.out.print("Enter the First Name: ");
		firstName = scnr.next();
		System.out.print("Enter the Last Name: ");
		lastName = scnr.next();

		System.out.print("Enter the Address: ");
		scnr.skip("[\r\n]+");
		address = scnr.nextLine();
		System.out.print("Enter the 8-digit Phone Number: ");
		try {
			phoneNumber = scnr.nextInt();
			if ((phoneNumber <= 10000000) || (phoneNumber >= 99999999)) {
				int hi = 10 / 0;
				System.out.println(hi);
			}

		} catch (ArithmeticException ex) {
			System.out.println("Error: must be an 8-digit phone number.");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("Error: must be an 8-digit phone number.");
			System.exit(0);
		}

		System.out.println("");
		System.out.println("Record entered. Exit the program to save results.");
		System.out.println("");
	}

	// storeInfo takes user input and creates a new record on file_records.txt
	public void storeInfo() throws IOException {
		fw.write("Customer ID: " + id + " ");
		fw.write("First Name: " + firstName + " ");
		fw.write("Last Name: " + lastName + " ");
		fw.write("Address: " + address + " ");
		fw.write("Phone Number: " + phoneNumber + " ");
		fw.write("\n");
		fw.flush();

	}
}
