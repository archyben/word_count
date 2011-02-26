package org.archy.wordcount.app.ihm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import org.archy.wordcount.app.ihm.controller.IController;

public class PathView extends JPanel implements IPathView, Observer {

	private static final long serialVersionUID = 3571728584736685735L;
	private final IController fileLoad;
	private File path;

	private class PathActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jFileChooser = new JFileChooser();
			int returnValue = jFileChooser.showOpenDialog(PathView.this);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				path = jFileChooser.getSelectedFile();
				fileLoad.execute();
			}

		}
	}

	public PathView(IController fileLoad) {
		super();
		this.fileLoad = fileLoad;
		JButton button = new JButton("Ouvrir");// TODO faire en sorte d'avoir le
		// multilangue
		button.addActionListener(new PathActionListener());
		add(button);
	}

	@Override
	public File getPath() {
		return path;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO add javadoc warning

	}

}
