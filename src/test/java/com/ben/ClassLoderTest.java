package com.ben;


import java.net.URL;

import org.junit.Test;

public class ClassLoderTest {
	// 加载jre/lib
	@Test
	public void printBootstrapClassLoader() {
		System.out.println("----------打印BootstrapClassPath 路径----------------");
		 URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			URL url = urls[i];
			System.out.println(url.toExternalForm());
		}
		
	}
	
	@Test
	public void printExtensionClassLoader() {
		System.out.println("----------打印extensionClassLoader路径----------------");
		 System.out.println(System.getProperty("java.ext.dirs"));
		   ClassLoader extensionClassloader=ClassLoader.getSystemClassLoader().getParent();
		   System.out.println("the parent of extension classloader : "+extensionClassloader.getParent());
	}
	
	// 打印classPath 路径
	@Test
	public void printClassPath() {
		System.out.println("----------打印classPath 路径----------------");
		String classPath = System.getProperty("java.class.path");
		String[] classPaths = classPath.split(";");
		for (String c : classPaths) {
			System.out.println(c);
		}
	}
}
