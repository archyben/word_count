package org.archy.wordcount.config;

import java.io.File;

import org.archy.wordcount.app.ihm.view.FrameView;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ManualConfig {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext context;
		BeanFactory beanFactory;
		
		System.out.println(new File(".").getAbsolutePath());
		
		context = new GenericXmlApplicationContext("spring-beans.xml");
		beanFactory = context.getBeanFactory();
		
		FrameView frameView = (FrameView) beanFactory.getBean("frameView");
		frameView.init();
	}
}
