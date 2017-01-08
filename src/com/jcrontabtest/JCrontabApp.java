package com.jcrontabtest;

import org.jcrontab.CronTask;
import org.jcrontab.Crontab;

public class JCrontabApp {
	private static Crontab cron = null;
    private String JcrontabFile = null;
    
    public JCrontabApp() {
    }
    
    public String getJcrontabFile() {
        return JcrontabFile;
    }

    public void setJcrontabFile(String jcrontabFile) {
        JcrontabFile = jcrontabFile;
    }
    
    public void getStart(){
    	
    	cron = Crontab.getInstance();
    	try {
    		cron.setDaemon(false);
    		cron.init(JcrontabFile);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    }
    
    public void getTask(){
    	CronTask[] ct = cron.getAllTasks();
    	System.out.println(ct.length);
    }
    
	public static void main(String args[]){
		JCrontabApp jc = new JCrontabApp();
		jc.setJcrontabFile("C:/Users/ivan.yu/workspace/JCrontabTest/src/jcrontab.properties");
		jc.getStart();
		//jc.getTask();
	}
}
