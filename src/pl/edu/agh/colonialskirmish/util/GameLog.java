package pl.edu.agh.colonialskirmish.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GameLog {

	protected StringBuilder gameLog = new StringBuilder();

	public synchronized void append( String line ) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		this.gameLog.append("[");
		this.gameLog.append(dateFormat.format(date));
		this.gameLog.append("] ");
		gameLog.append(line);
		gameLog.append("\n");
	}

	@Override
	public String toString() {
		return gameLog.toString();
	}

}
