package itay.friedman.multi_trainees_timer;

import java.io.Serializable;

public class Mtimer  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6950831719447154130L;
	
	public String name = "";
	public int hour = 00;
	public int min = 00;
	public int sec = 00;
	
	public Mtimer(String name, int hour, int min, int sec) {
		this.setName(name);
		this.setHour(hour);
		this.setMin(min);
		this.setMin(sec);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public double getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public double getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}
}
