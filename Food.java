//Àsjava -cp .;jsoup-1.15.3.jar SampleCode
import java.time.LocalDate;
public class Food {
	private String name;
	private LocalDate timeLimit;
	/*private int year;//”N
	private int month;//Œ
	private int day;//“ú*/
	public Food(){
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setTimeLimit(int year, int month, int day){
		this.timeLimit = LocalDate.of(year,month,day);
	}
	public LocalDate getTimeLimit(){
		return this.timeLimit;
	}
}