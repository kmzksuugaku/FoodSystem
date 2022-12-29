import java.util.List;
import java.util.ArrayList;

public class Recipe {
	private String name;
	private String url;
	private List<Food2> list = new ArrayList<Food2>();
	public Recipe(){
		
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return this.url;
	}
	public void setList(List<Food2> list){
		this.list = list;
	}
	public List<Food2> getList(){
		return this.list;
	}
	public void add(Food2 food){
		this.list.add(food);
	}
	public Food2 get(int index){
		return this.list.get(index);
	}
	public Food2 remove(int index){
		return this.list.remove(index);
	}
	public int size(){
		return this.list.size();
	}
}