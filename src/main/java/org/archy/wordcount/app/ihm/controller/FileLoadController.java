package org.archy.wordcount.app.ihm.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;

import org.archy.wordcount.app.business.IWordCount;
import org.archy.wordcount.app.ihm.common.MessageConstante;
import org.archy.wordcount.app.ihm.common.TypeMessageEnum;
import org.archy.wordcount.app.ihm.model.DialogBean;
import org.archy.wordcount.app.ihm.model.WordCountBean;
import org.archy.wordcount.app.ihm.view.IPathView;

public class FileLoadController extends Observable implements IController {

	private DialogBean dialogBean;
	private IPathView pathView;
	private final WordCountBean wordCountBean;
	private final IWordCount wordCount;

	public FileLoadController(IPathView pathView, IWordCount wordCount,
			WordCountBean wordCountBean, DialogBean dialogBean) {
		super();
		this.pathView = pathView;
		this.wordCount = wordCount;
		this.wordCountBean = wordCountBean;
		this.dialogBean = dialogBean;
	}

	@Override
	public void execute() {
		File path = pathView.getPath();
		Map<String, Integer> statistics = null;
		try {
			statistics = wordCount.getStatistics(path);
		} catch (IOException ex) {
			dialogBean.setMessage(MessageConstante.FILE_NOT_FOUND.replaceFirst(
					"/{}/", path.getName()));
			dialogBean.setThrowable(ex);
			dialogBean.setTypeMessageEnum(TypeMessageEnum.ERROR);
			dialogBean.notifyObservers();
			return;
		}
		wordCountBean.setStatistics(statistics);
		wordCountBean.setPath(path);
		wordCountBean.notifyObservers();
	}

	public DialogBean getDialogBean() {
		return dialogBean;
	}

	public void setDialogBean(DialogBean dialogBean) {
		this.dialogBean = dialogBean;
	}

	public IPathView getPathView() {
		return pathView;
	}

	public void setPathView(IPathView pathView) {
		this.pathView = pathView;
	}
}
