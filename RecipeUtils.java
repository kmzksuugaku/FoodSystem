public class RecipeUtils{
	public static void print(Recipe recipe){
		//レシピ名,レシピのURL,レシピの材料表を表示
		Output.printTitle(recipe.getName());
		Output.printURL(recipe.getUrl());
		for(int i = 0; i < recipe.size(); i++) {
			int a = i + 1;
			System.out.println("材料" + a + ":" + recipe.get(i).getName() + " " + recipe.get(i).getQuantity());
		}
	}
}