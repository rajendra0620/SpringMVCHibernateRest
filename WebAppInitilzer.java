package com.Metro.Intilizer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitilzer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("AAAAAAAAAA");
		return new Class[]{HibernateConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("BBBBBBBBB");

		return new Class[]{SpringConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("CCCCCCCCCCC");
		return new String[]{"/"};
	}

}
