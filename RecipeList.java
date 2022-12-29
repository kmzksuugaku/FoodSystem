import java.util.List;
import java.util.ArrayList;

public class RecipeList {
	private String name;
	private List<Recipe> list = new ArrayList<Recipe>();
	public RecipeList(){
		
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setList(List<Recipe> list){
		this.list = list;
	}
	public List<Recipe> getList(){
		return this.list;
	}
	public void add(Recipe recipe){
		this.list.add(recipe);
	}
	public Recipe get(int index){
		return list.get(index);
	}
	public Recipe remove(int index){
		return list.remove(index);
	}
	public int size(){
		return list.size();
	}
}