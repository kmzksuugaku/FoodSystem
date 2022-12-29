import java.util.ArrayList;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class SampleCode {
	public static void main(String[] args) throws IOException {
		//システム利用者が食材と時間を入力。リストを作成。
		ArrayList<Food> list = Input.getInput();
		//検索
		StringBuffer search = SearchThings.getSearchName(list);
		//検索結果をスクレイピング
		Document doc = Jsoup.connect("https://cookpad.com/recipe/list/10421939?utf8=%E2%9C%93&keyword=" + search).get();
		//検索結果からレシピのURLたちを取得
		ArrayList<String> urls = SearchThings.getURLs(doc);
		//検索結果からレシピ名たちを取得
		ArrayList<String> titles = SearchThings.getTitles(doc);
		
		RecipeList recipeList = new RecipeList();
		//結果を表示
		for(int i = 0; i < urls.size(); i++) {
			//レシピのURLのdocumentを取得
			Document rs = Jsoup.connect(urls.get(i)).get();
			//材料名を取得
			ArrayList<String> names = SearchThings.getIngredientNames(rs);
			//材料の量を取得
			ArrayList<String> quantities = SearchThings.getIngredientQuantites(rs);
			
			Recipe recipe = new Recipe();
			//保存用のレシピに代入
			recipe.setList(Assign.getRecipeIngredients(names, quantities));
			recipe.setName(titles.get(i));
			recipe.setUrl(urls.get(i));
			//保存用のレシピを保存用のレシピリストに代入
			recipeList.add(recipe);
			
			//表示
			RecipeUtils.print(recipe);
			System.out.println("");
		}
		//"サーチした内容 + List.xml"を保存する
		String filename = search + "List.xml";
		RecipeListUtils.save(filename,recipeList);
	}
}