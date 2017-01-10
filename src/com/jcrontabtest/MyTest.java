package com.jcrontabtest;

import java.util.ArrayList;
import java.util.Calendar;

public class MyTest {
	public static void main(String[] args) {
		Calendar cl = Calendar.getInstance();
		System.out.println(cl.getTime());
		for(int i = 0; i < 8; i++){
			getPlanList(cl, "2", "31", "*", "*", "*", "5");
			System.out.println(cl.getTime());
			cl.add(Calendar.SECOND, 1);
		}
		
	}
	
	public static void getPlanList(Calendar cl, String ctM, String ctW, String ctD, String ctHH, String ctMM, String ctSS){

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
		
		int newM = 0;
		int newW = 0;
		int newD = 0;
		int newHH = 0;
		int newMM = 0;
		int newSS = 0;
		
		int oldY = 0;
		int oldM = 0;
		int oldD = 0;
		int oldHH = 0;
		int oldMM = 0;
		
		int repeatCount = 0;
		
		boolean isFoundDay = false;
		boolean isFoundTime = false;
		
		int rangeFrom = 0;
		int rangeTo = 0;
		int rangePoint = 0;
		int step = 0;
		
		oldY = cl.get(Calendar.YEAR);
		oldM = cl.get(Calendar.MONTH);
		oldD = cl.get(Calendar.DATE);
		oldHH = cl.get(Calendar.HOUR_OF_DAY);
		oldMM = cl.get(Calendar.MINUTE);
		
		if(ctM.contains("*")){
			for(int i = 0; i < 12; i++){
				M.add(i + 1);
			}
		}
		else{
			vs_M = ctM.split(",");
			for(int i = 0; i < vs_M.length; i++){
				M.add(Integer.parseInt(vs_M[i]));
			}
		}
		
		if(ctW.contains("*")){
			for(int i = 0; i < 7; i++){
				W.add(i + 1);
			}
		}
		else{
			vs_W = ctW.split(",");
			for(int i = 0; i < vs_W.length; i++){
				W.add(Integer.parseInt(vs_W[i]));
			}
		}
		
		if(ctD.contains("*")){
			for(int i = 0; i < 31; i++){
				D.add(i + 1);
			}
		}
		else{
			vs_D = ctD.split(",");
			for(int i = 0; i < vs_D.length; i++){
				D.add(Integer.parseInt(vs_D[i]));
			}
		}
		
		rangeFrom = 0;
		rangeTo = 0;
		rangePoint = 0;
		step = 0;
		if(ctHH.contains("*")){
			ctHH = ctHH.replace("*", "0-23");
		}
		if(ctHH.contains("-")){
			if(ctHH.contains("/")){
				rangeFrom = Integer.parseInt(ctHH.split("/")[0].split("-")[0]);
				rangeTo = Integer.parseInt(ctHH.split("/")[0].split("-")[1]);
				step = Integer.parseInt(ctHH.split("/")[1]);
				rangePoint = rangeFrom;
			}
			else{
				rangeFrom = Integer.parseInt(ctHH.split("-")[0]);
				rangeTo = Integer.parseInt(ctHH.split("-")[1]);
				step = 1;
				rangePoint = rangeFrom;
			}
			while(rangePoint <= rangeTo){
				HH.add(rangePoint);
				rangePoint = rangePoint + step;
			}
		}
		else{
			vs_HH = ctHH.split(",");
			for(int i = 0; i < vs_HH.length; i++){
				HH.add(Integer.parseInt(vs_HH[i]));
			}
		}
		
		rangeFrom = 0;
		rangeTo = 0;
		rangePoint = 0;
		step = 0;
		if(ctMM.contains("*")){
			ctMM = ctMM.replace("*", "0-59");
		}
		if(ctMM.contains("-")){
			if(ctMM.contains("/")){
				rangeFrom = Integer.parseInt(ctMM.split("/")[0].split("-")[0]);
				rangeTo = Integer.parseInt(ctMM.split("/")[0].split("-")[1]);
				step = Integer.parseInt(ctMM.split("/")[1]);
				rangePoint = rangeFrom;
			}
			else{
				rangeFrom = Integer.parseInt(ctMM.split("-")[0]);
				rangeTo = Integer.parseInt(ctMM.split("-")[1]);
				step = 1;
				rangePoint = rangeFrom;
			}
			while(rangePoint <= rangeTo){
				MM.add(rangePoint);
				rangePoint = rangePoint + step;
			}
		}
		else{
			vs_MM = ctMM.split(",");
			for(int i = 0; i < vs_MM.length; i++){
				MM.add(Integer.parseInt(vs_MM[i]));
			}
		}
		
		rangeFrom = 0;
		rangeTo = 0;
		rangePoint = 0;
		step = 0;
		if(ctSS.contains("*")){
			ctSS = ctSS.replace("*", "0-59");
		}
		if(ctSS.contains("-")){
			if(ctSS.contains("/")){
				rangeFrom = Integer.parseInt(ctSS.split("/")[0].split("-")[0]);
				rangeTo = Integer.parseInt(ctSS.split("/")[0].split("-")[1]);
				step = Integer.parseInt(ctSS.split("/")[1]);
				rangePoint = rangeFrom;
			}
			else{
				rangeFrom = Integer.parseInt(ctSS.split("-")[0]);
				rangeTo = Integer.parseInt(ctSS.split("-")[1]);
				step = 1;
				rangePoint = rangeFrom;
			}
			while(rangePoint <= rangeTo){
				SS.add(rangePoint);
				rangePoint = rangePoint + step;
			}
		}
		else{
			vs_SS = ctSS.split(",");
			for(int i = 0; i < vs_SS.length; i++){
				SS.add(Integer.parseInt(vs_SS[i]));
			}
		}		
				
		isFoundDay = false;
		while(!isFoundDay){
			newM = cl.get(Calendar.MONTH) + 1;
			for(int i = 0; i < M.size(); i++){
				if(newM <= M.get(i)){
					cl.set(Calendar.MONTH, M.get(i) - 1);
					if(newM == M.get(i)){
						newD = cl.get(Calendar.DATE);
					}
					else{
						newD = 1;
					}
					cl.set(Calendar.DATE, newD);
					for(int j = 0; j < D.size(); j++){
						if(newD <= D.get(j)){
							if(D.get(j) > getLastDay(cl)){
								break;
							}
							cl.set(Calendar.DATE, D.get(j));
							newW = cl.get(Calendar.DAY_OF_WEEK);
							if(newW - 1 == 0){
								newW = 7;
							}
							else{
								newW = newW - 1;
							}
							for(int k = 0; k < W.size(); k++){
								if(newW == W.get(k)){
									isFoundDay = true;
									break;
								}
							}
						}
						if(isFoundDay){
							break;
						}
					}
				}
				if(isFoundDay){
					break;
				}
			}
			if(isFoundDay){
				
				if(oldY == cl.get(Calendar.YEAR) && oldM == cl.get(Calendar.MONTH) && oldD == cl.get(Calendar.DATE)){
					
				}
				else{
					cl.set(Calendar.HOUR_OF_DAY, 0);
					cl.set(Calendar.MINUTE, 0);
					cl.set(Calendar.SECOND, 0);
				}		
				
				newHH = cl.get(Calendar.HOUR_OF_DAY);
				for(int i = 0; i < HH.size(); i++){
					if(newHH <= HH.get(i)){
						cl.set(Calendar.HOUR_OF_DAY, HH.get(i));
						if(cl.get(Calendar.HOUR_OF_DAY) != oldHH){
							cl.set(Calendar.MINUTE, 0);
							cl.set(Calendar.SECOND, 0);
						}
						
						newMM = cl.get(Calendar.MINUTE);
						for(int j = 0; j < MM.size(); j++){
							if(newMM <= MM.get(j)){
								cl.set(Calendar.MINUTE, MM.get(j));
								if(cl.get(Calendar.MINUTE) != oldMM){
									cl.set(Calendar.SECOND, 0);
								}
								
								newSS = cl.get(Calendar.SECOND);
								for(int k = 0; k < SS.size(); k++){
									if(newSS <= SS.get(k)){
										cl.set(Calendar.SECOND, SS.get(k));
										isFoundTime = true;
										break;
									}		
								}
								if(isFoundTime){
									break;
								}
							}
						}
						if(isFoundTime){
							break;
						}
					}
				}			
				
			}
			else{
				cl.add(Calendar.YEAR, 1);
				cl.set(Calendar.MONTH, 0);
				cl.set(Calendar.DATE, 1);
				repeatCount = repeatCount + 1;
			}
			
			if(isFoundTime){
				break;
			}
			else{
				isFoundDay = false;
				cl.add(Calendar.DATE, 1);
				cl.set(Calendar.HOUR_OF_DAY, 0);
				cl.set(Calendar.MINUTE, 0);
				cl.set(Calendar.SECOND, 0);
			}
			
			if(repeatCount > 100){
				System.out.println("100年内无符合日期时间！");
				break;
			}
		}	
	}
	
	public static int getLastDay(Calendar cl){
		int lastDay = 0;
		cl.set(Calendar.DATE, 1);
		cl.add(Calendar.MONTH, 1);
		cl.add(Calendar.DATE, -1);
		lastDay = cl.get(Calendar.DATE);
		return lastDay;
	}
}
