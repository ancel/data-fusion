package com.work.data_fusion;


public class App {
	static {
		System.setProperty("user.timezone","GMT+8");
		System.setProperty("log4j.configurationFile", "conf/log4j2.xml");
		System.setProperty("com.mchange.v2.c3p0.cfg.xml", "conf/c3p0-config.xml");
    }
	public static void main(String[] args) {
		boolean result = new AppTool().run(args);
		if(!result){
			System.exit(1);
		}
	}
}
