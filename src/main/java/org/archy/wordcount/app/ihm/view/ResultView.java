package org.archy.wordcount.app.ihm.view;

import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResultView extends JScrollPane implements IResultView {

	private static final long serialVersionUID = -587576811307487193L;
	private final TableView tableView;

	private JTable jTable;

	public ResultView(TableView TableView) {
		super();
		this.tableView = TableView;
		jTable = new JTable(TableView);
		setViewportView(jTable);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		tableView.updateValues();
		jTable.updateUI();
	}
}
