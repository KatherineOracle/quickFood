package kv.hyperiondev.java.quickfood;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Comparator;
import java.util.Formatter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

public class Drivers {

	// properties
	private List<Driver> driverList = new ArrayList<>();
	private String driverFile = "data/drivers.txt";

	// constructor
	public Drivers() throws SecurityException, IOException {

		// read through the driver text file and create a driver object from each row

		try {
			File driverSrc = new File(driverFile);
			Scanner sc = new Scanner(driverSrc);

			while (sc.hasNextLine()) {
				// read the line
				String driverString = sc.nextLine();

				// split the line of text into an array at the comma
				String[] driverArr = driverString.split(", ");

				// create the driver and add it to our ArrayList of drivers
				driverList.add(new Driver(driverArr[0], driverArr[1], Integer.parseInt(driverArr[2])));

			}

			// close scanner as we should
			sc.close();

		} catch (FileNotFoundException e) {

			ErrorLog.log("Driver file not found."+e.getMessage());

		}

	}

	// method to check if there are any drivers in the requested city
	public boolean isAvailable(String textRestaurantCity) {

		List<Driver> drivers = this.driverList;

		// use an optional in case the result of the filter is null.
		Optional<Driver> sortedList = drivers.stream()

				// sort the drivers according to their load
				.sorted(Comparator.comparing(Driver::getLoad))

				// only return drivers with same city
				.filter(d -> d.getCity().equals(textRestaurantCity))

				// are their any results?
				.findAny();

		return sortedList.isPresent();
	}

	private void saveToFile() throws SecurityException, IOException {
		try (Formatter writer = new Formatter(driverFile)) {
			// dump the string into a file

			this.driverList.forEach(driver -> writer.format("%s%n", driver.toString()));

		} catch (FileNotFoundException e) {

			ErrorLog.log("Driver file not found."+e.getMessage());

		}
	}

	// method to return driver in the selected city with the smallest load
	public Driver appoint(String textRestaurantCity) throws SecurityException, IOException {

		// create a list drivers in matching city, ordered by load
		List<Driver> sortedList;
		sortedList = driverList.stream().sorted(Comparator.comparing(Driver::getLoad))
				.filter(d -> d.getCity().equals(textRestaurantCity)).collect(Collectors.toList());

		// get the driver at top of list
		Driver appointed = sortedList.get(0);

		// update driver load
		appointed.addToLoad();

		// save the driver file
		this.saveToFile();

		// send selected driver object back to main app
		return appointed;
	}

}