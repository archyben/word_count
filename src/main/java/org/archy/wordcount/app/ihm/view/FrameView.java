package org.archy.wordcount.app.ihm.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FrameView extends JFrame implements Observer {

	private static final long serialVersionUID = -7148874998131623617L;
	private final JComponent resultView;
	private final JComponent pathView;

	public FrameView(JComponent resulView, JComponent pathView)
			throws HeadlessException {
		super();
		setSize(1024, 768);// TODO get into the config.properties
		this.resultView = resulView;
		this.pathView = pathView;
	}

	public void init() {
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		add(this.pathView, BorderLayout.SOUTH);
		add(this.resultView, BorderLayout.CENTER);
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		//TODO log
	}
}
