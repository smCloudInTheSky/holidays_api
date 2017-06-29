package hello;

import java.time.LocalDateTime;

public class Time {
	private long id;
	private LocalDateTime date;
	
	public Time(long id){
		this.id = id;
		this.date = LocalDateTime.now();
	}
	
	public LocalDateTime getTime(){
		return date;
	}
	
	public long getId(){
		return id;
	}
	
	public void setTime(LocalDateTime ndate){
		this.date = ndate;
	}
	
	public void setId(long id){
		this.id = id;
	}

}
