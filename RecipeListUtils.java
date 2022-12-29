import java.io.File;
import javax.xml.bind.JAXB;

public class RecipeListUtils {
	public static void print(RecipeList recipeList){
		for(Recipe recipe : recipeList.getList()){
			RecipeUtils.print(recipe);
		}
	}
	public static void save(String filename, RecipeList recipeList){
		File file = new File(filename);
		JAXB.marshal(recipeList,file);
	}
	public static RecipeList load(String filename){
		File file = new File(filename);
		if(file.exists()){
			return JAXB.unmarshal(file,RecipeList.class);
		}
		return null;
	}
}