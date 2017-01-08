package com.jcrontabtest;

import java.util.ArrayList;
import java.util.Calendar;

public class MyTest {
	public static void main(String[] args) {
		String[] inputCrontab = new String[6];
		inputCrontab[0] = "1,3,11";
		inputCrontab[1] = "0,4,6";
		inputCrontab[2] = "1,6,14,31";
		inputCrontab[3] = "*/7";
		inputCrontab[4] = "3,5,8";
		inputCrontab[5] = "2-8/2";

		ArrayList<Integer> M = new ArrayList<Integer>();
		ArrayList<Integer> W = new ArrayList<Integer>();
		ArrayList<Integer> D = new ArrayList<Integer>();
		ArrayList<Integer> HH = new ArrayList<Integer>();
		ArrayList<Integer> MM = new ArrayList<Integer>();
		ArrayList<Integer> SS = new ArrayList<Integer>();
		
		String[] vs_M;
		String[] vs_W;
		String[] vs_D;
		String[] vs_HH;
		String[] vs_MM;
		String[] vs_SS;
		
		int rangeFrom = 0;
		int rangeTo = 0;
		int rangePoint = 0;
		int step = 0;
		
		Calendar cl = Calendar.getInstance();
		System.out.println(cl.getTime());
		//System.out.println(Calendar.SECOND);
		//cl.set(Calendar.SECOND, 20);
		//System.out.println(Calendar.SECOND);
		if(inputCrontab[0].contains("*")){
			for(int i = 0; i < 12; i++){
				M.add(i + 1);
			}
		}
		else{
			vs_M = inputCrontab[0].split(",");
			for(int i = 0; i < vs_M.length; i++){
				M.add(Integer.parseInt(vs_M[i]));
			}
		}
		
		if(inputCrontab[1].contains("*")){
			for(int i = 0; i < 7; i++){
				W.add(i + 1);
			}
		}
		else{
			vs_W = inputCrontab[1].split(",");
			for(int i = 0; i < vs_W.length; i++){
				W.add(Integer.parseInt(vs_W[i]));
			}
		}
		
		if(inputCrontab[2].contains("*")){
			for(int i = 0; i < 31; i++){
				D.add(i + 1);
			}
		}
		else{
			vs_D = inputCrontab[2].split(",");
			for(int i = 0; i < vs_D.length; i++){
				D.add(Integer.parseInt(vs_D[i]));
			}
		}
		
		rangeFrom = 0;
		rangeTo = 0;
		rangePoint = 0;
		step = 0;
		if(inputCrontab[3].contains("*")){
			inputCrontab[3] = inputCrontab[3].replace("*", "0-23");
		}
		if(inputCrontab[3].contains("-")){
			if(inputCrontab[3].contains("/")){
				rangeFrom = Integer.parseInt(inputCrontab[3].split("/")[0].split("-")[0]);
				rangeTo = Integer.parseInt(inputCrontab[3].split("/")[0].split("-")[1]);
				step = Integer.parseInt(inputCrontab[3].split("/")[1]);
				rangePoint = rangeFrom;
			}
			else{
				rangeFrom = Integer.parseInt(inputCrontab[3].split("-")[0]);
				rangeTo = Integer.parseInt(inputCrontab[3].split("-")[1]);
				step = 1;
				rangePoint = rangeFrom;
			}
			while(rangePoint <= rangeTo){
				HH.add(rangePoint);
				rangePoint = rangePoint + step;
			}
		}
		else{
			vs_HH = inputCrontab[3].split(",");
			for(int i = 0; i < vs_HH.length; i++){
				HH.add(Integer.parseInt(vs_HH[i]));
			}
		}
		
		rangeFrom = 0;
		rangeTo = 0;
		rangePoint = 0;
		step = 0;
		if(inputCrontab[4].contains("*")){
			inputCrontab[4] = inputCrontab[4].replace("*", "0-59");
		}
		if(inputCrontab[4].contains("-")){
			if(inputCrontab[4].contains("/")){
				rangeFrom = Integer.parseInt(inputCrontab[4].split("/")[0].split("-")[0]);
				rangeTo = Integer.parseInt(inputCrontab[4].split("/")[0].split("-")[1]);
				step = Integer.parseInt(inputCrontab[4].split("/")[1]);
				rangePoint = rangeFrom;
			}
			else{
				rangeFrom = Integer.parseInt(inputCrontab[4].split("-")[0]);
				rangeTo = Integer.parseInt(inputCrontab[4].split("-")[1]);
				step = 1;
				rangePoint = rangeFrom;
			}
			while(rangePoint <= rangeTo){
				MM.add(rangePoint);
				rangePoint = rangePoint + step;
			}
		}
		else{
			vs_MM = inputCrontab[4].split(",");
			for(int i = 0; i < vs_MM.length; i++){
				MM.add(Integer.parseInt(vs_MM[i]));
			}
		}
		
		rangeFrom = 0;
		rangeTo = 0;
		rangePoint = 0;
		step = 0;
		if(inputCrontab[5].contains("*")){
			inputCrontab[5] = inputCrontab[5].replace("*", "0-59");
		}
		if(inputCrontab[5].contains("-")){
			if(inputCrontab[5].contains("/")){
				rangeFrom = Integer.parseInt(inputCrontab[5].split("/")[0].split("-")[0]);
				rangeTo = Integer.parseInt(inputCrontab[5].split("/")[0].split("-")[1]);
				step = Integer.parseInt(inputCrontab[5].split("/")[1]);
				rangePoint = rangeFrom;
			}
			else{
				rangeFrom = Integer.parseInt(inputCrontab[5].split("-")[0]);
				rangeTo = Integer.parseInt(inputCrontab[5].split("-")[1]);
				step = 1;
				rangePoint = rangeFrom;
			}
			while(rangePoint <= rangeTo){
				SS.add(rangePoint);
				rangePoint = rangePoint + step;
			}
		}
		else{
			vs_SS = inputCrontab[5].split(",");
			for(int i = 0; i < vs_SS.length; i++){
				SS.add(Integer.parseInt(vs_SS[i]));
			}
		}
//		try{
//			Thread.sleep(3000);
//		}
//		catch(Exception e){
//			
//		}
		System.out.println(cl.getTime());
	}
}
