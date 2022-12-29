//実行java -cp .;jsoup-1.15.3.jar SampleCode
import java.time.LocalDate;
public class Food {
	private String name;
	private LocalDate timeLimit;
	/*private int year;//年
	private int month;//月
	private int day;//日*/
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