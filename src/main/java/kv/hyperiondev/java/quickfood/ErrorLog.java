package kv.hyperiondev.java.quickfood;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ErrorLog {

	private static String errorFile = "data/errors.log";

	private ErrorLog() {

	}

	public static void log(String message) throws SecurityException, IOException {
		Logger logger = Logger.getLogger("");
		FileHandler fileHandler;

		try {
			fileHandler = new FileHandler(errorFile);
			logger.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			logger.severe(message);
			fileHandler.close();
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

	}

}
