import java.util.ArrayList;

public class Assign {
	public static ArrayList<Food2> getRecipeIngredients(ArrayList<String> names,ArrayList<String> quantities){
		ArrayList<Food2> list = new ArrayList<>();
		for(int i = 0; i < names.size(); i++) {
			Food2 food = new Food2();
			food.setName(names.get(i));
			food.setQuantity(quantities.get(i));
			list.add(food);
		}
		return list;
	}
}