package org.archy.wordcount.app.ihm.model;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class WordCountBean extends Observable {
	private File path;
	private Map<String, Integer> statistics;

	public WordCountBean(Collection<Observer> observers) {
		for (Observer observer : observers) {
			addObserver(observer);
		}
	}
	
	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		setChanged();
		this.path = path;
	}

	public Map<String, Integer> getStatistics() {
		return statistics;
	}

	public void setStatistics(Map<String, Integer> statistics) {
		setChanged();
		this.statistics = statistics;
	}
}
