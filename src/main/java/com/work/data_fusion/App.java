package com.work.data_fusion;


public class App {
	static {
		System.setProperty("user.timezone","GMT+8");
		System.setProperty("log4j.configurationFile", "conf/log4j2.xml");
    }
	public static void main(String[] args) {
		boolean result = new AppTool().run(args);
		if(!result){
			System.exit(1);
		}
	}
}
