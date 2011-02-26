package org.archy.wordcount.app.business;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface IWordCount {
	/**
	 * Retrieve statistics about a text file
	 * 
	 * @param path
	 *            file path
	 * @return statistics (keys->word,values->occurrence)
	 */
	Map<String, Integer> getStatistics(File path) throws IOException;
}
