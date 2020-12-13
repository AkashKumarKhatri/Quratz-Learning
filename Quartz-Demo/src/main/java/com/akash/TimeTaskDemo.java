package com.akash;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTaskDemo {

	public static void main(String[] args) {
		new Timer().schedule(new Schedular(), 0, 5000);
	}

}

class Schedular extends TimerTask {

	@Override
	public void run() {
		System.out.println("Hello!!");
	}
	
}
