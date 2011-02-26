package org.archy.wordcount.app.ihm.model;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import org.archy.wordcount.app.ihm.common.TypeMessageEnum;

public class DialogBean extends Observable {
	private Throwable throwable;
	private String message;
	private TypeMessageEnum typeMessageEnum;

	public DialogBean(Collection<Observer> observers) {
		for (Observer observer : observers) {
			addObserver(observer);
		}
	}
	
	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		setChanged();
		this.throwable = throwable;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		setChanged();
		this.message = message;
	}

	public TypeMessageEnum getTypeMessageEnum() {
		return typeMessageEnum;
	}

	public void setTypeMessageEnum(TypeMessageEnum typeMessageEnum) {
		setChanged();
		this.typeMessageEnum = typeMessageEnum;
	}
}
