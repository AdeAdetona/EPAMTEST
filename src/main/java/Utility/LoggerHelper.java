package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerHelper {
	
	private static Logger logger = LogManager.getLogger();

    public static void log(String message) {
        logger.info(message);
    }

}
