package org.archy.wordcount.app.business.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class InputStreamFacade implements IInputStreamFacade {

	private BufferedReader input;
	private String actualLine = "";

	@Override
	public void loadFile(File path) throws IOException {
		if (input != null) {
			try {
				input.close();
				// TODO : add log warning
			} catch (IOException e) {
				// TODO: add log OK
			}
		}
		try {
			input = new BufferedReader(new FileReader(path));
			actualLine = "";
			next();
		} catch (IOException ex) {
			throw new IOException(ex);
		}

	}

	@Override
	public Iterator<String> iterator() {
		return this;
	}

	/**
	 * check if the file has still line
	 */
	@Override
	public boolean hasNext() {
		return actualLine != null;
	}

	/**
	 * return the next line;
	 */
	@Override
	public String next() {
		if (actualLine == null) {
			throw new NoSuchElementException();
		}
		String line = actualLine;
		try {
			actualLine = input.readLine();
		} catch (IOException e) {
			actualLine = null;
		}
		return line;
	}

	/**
	 * /!\ can't remove String element
	 */
	@Deprecated
	@Override
	public void remove() {
		throw new UnsupportedOperationException("can't remove String element");

	}

	@Override
	public void closeFile() throws IOException {
		input.close();
	}
}
