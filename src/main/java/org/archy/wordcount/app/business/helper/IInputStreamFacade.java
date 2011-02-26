package org.archy.wordcount.app.business.helper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public interface IInputStreamFacade extends Iterable<String>, Iterator<String> {
	void loadFile(File path) throws IOException;

	Iterator<String> iterator();

	void closeFile() throws IOException;
}
