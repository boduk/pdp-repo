package logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample {

	private static final Logger LOGGER_ROOT = Logger.getLogger("");
	private static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
	private static final Logger LOGGER_2 = Logger.getLogger("myLogger");

	public static void main(String[] args) throws SecurityException, IOException {

		LOGGER_ROOT.info("test message");
		/* ================================================ */

		LOGGER.addHandler(new FileHandler("test.log"));
		LOGGER.addHandler(new ConsoleHandler());
		LOGGER.info("in main()");
		/* ================================================ */

		LOGGER_2.log(Level.SEVERE, "Error code: {0}", 500);
		/* ================================================ */

		LOGGER_2.setUseParentHandlers(false);

		System.out.println();
		ConsoleHandler consoleHandler = new ConsoleHandler();
		LOGGER_2.addHandler(consoleHandler);
		LOGGER_2.info("not formated message");

		System.out.println();
		LOGGER_2.removeHandler(consoleHandler);
		consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new MyFormatter());
		LOGGER_2.addHandler(consoleHandler);
		LOGGER_2.info("formated message");
		/* ================================================ */
	}

}
