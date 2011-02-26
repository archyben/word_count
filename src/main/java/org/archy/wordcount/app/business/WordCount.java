/**
 * 
 */
package org.archy.wordcount.app.business;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.archy.wordcount.app.business.helper.IInputStreamFacade;

/**
 * @author archy
 * 
 */
public class WordCount implements IWordCount {

	private final IInputStreamFacade inputStreamFacade;

	public WordCount(IInputStreamFacade inputStreamFacade) {
		super();
		this.inputStreamFacade = inputStreamFacade;
	}

	@Override
	public Map<String, Integer> getStatistics(File path) throws IOException {
		inputStreamFacade.loadFile(path);
		Map<String, Integer> statistics = new HashMap<String, Integer>();
		for (String line : inputStreamFacade) {
			String[] splitLine = line.split(" ");
			for (String word : splitLine) {
				String wordLowerCase = word.toLowerCase();
				int occurrence = 1;
				if (statistics.containsKey(wordLowerCase)) {
					occurrence = statistics.get(wordLowerCase) + 1;
				}
				statistics.put(wordLowerCase, occurrence);
			}
		}
		inputStreamFacade.closeFile();
		return statistics;
	}
}
