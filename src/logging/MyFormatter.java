package logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		Date date = new Date(record.getMillis());
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String logDate = format.format(date);

		StringBuilder builder = new StringBuilder();
		builder.append(logDate).append(" - ").append(record.getLoggerName()).append(" - ").append(record.getLevel())
				.append(": ").append(record.getMessage()).append("\n");
		return builder.toString();
	}

}
