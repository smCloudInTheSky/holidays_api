package hello;

import java.time.LocalDate;

public class Hour {
	private long id;
	private LocalDate date;	
	
	public Hour(){
		this.date = LocalDate.now();
	}
	
	public Hour(long id){
		this.id = id;
		this.date = LocalDate.now();
	}
	
	public Hour(long id, String sdate) {
		this.id = id;
		this.date = LocalDate.parse(sdate);
	}

	public LocalDate getDate(){
		return date;
	}
	
	public long getId(){
		return id;
	}
	
	public String getSdate(){
		return LocalDate.now().toString();
	}
	
	
	public void setDate(LocalDate date){
		this.date = date;
	}
		
	@Override
	public String toString(){
		return "Customer [date= "+ date +"]";
	}

}
