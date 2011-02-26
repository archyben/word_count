package org.archy.wordcount.app.ihm.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import org.archy.wordcount.app.ihm.model.WordCountBean;

public class TableView extends AbstractTableModel {

	private static final long serialVersionUID = 3289726081848127131L;
	private final WordCountBean wordCountBean;
	private Set<Entry<String, Integer>> statistics;

	public TableView(WordCountBean wordCountBean) {
		super();
		this.wordCountBean = wordCountBean;
	}

	public void setStatistics(Set<Entry<String, Integer>> statistics) {
		this.statistics = statistics;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		if (statistics == null) {
			return 0;
		}
		return statistics.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		int length = statistics.size();
		if (length <= arg0) {
			return null;
		}
		Iterator<Entry<String, Integer>> it = statistics.iterator();
		Entry<String, Integer> value = it.next();
		for (int i = 0; i < arg0; i++) {
			value = it.next();
		}
		return (arg1 == 0 ? value.getKey() : value.getValue());
	}

	public void updateValues() {
		Map<String, Integer> statMap = wordCountBean.getStatistics();
		if (statMap == null) {
			return;
		}
		statistics = statMap.entrySet();
	}

}
