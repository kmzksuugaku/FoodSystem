import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.time.LocalDate;
public class SearchThings {
	public static StringBuffer getSearchName(ArrayList<Food> list){
		StringBuffer search = new StringBuffer();
		LocalDate today = LocalDate.now();//ç°ì˙
		LocalDate ptoday = today.plusDays(11);//ç°ì˙Ç©ÇÁ11ì˙å„
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTimeLimit().isBefore(ptoday)) {
				search.append(list.get(i).getName() + " ");
			}
		}
		return search;
	}
	public static ArrayList<String> getURLs(Document doc){
		String s = doc.html();
		ArrayList<String> uks = new ArrayList<>();
		String ukss = "";
		for(int i = 0; i < s.length(); i++) {
			String ans = "&quot;recipe_ids&quot;:[";
			if(s.substring(i,i + ans.length()).equals(ans)) { 
				int k = 1;
				while(true) {
					if(s.substring(i + ans.length() + k,i + ans.length() + k + 1).equals("]")) break;
					k++;
				}
				ukss = s.substring(i + ans.length(),i + ans.length() + k);
				break;
			}
		}
		ukss += ",";
		String k = "";
		for(int i = 0; i < ukss.length(); i++) {
			k += ukss.substring(i,i + 1);
			if(ukss.substring(i,i + 1).equals(",")) {
				uks.add(k.substring(0,k.length() - 1));
				k = "";
			}
		}
		ArrayList<String> urls = new ArrayList<>();
		for(int i = 0; i < uks.size(); i++) {
			urls.add("https://cookpad.com/recipe/" + uks.get(i));
		}
		return urls;
	}
	public static ArrayList<String> getTitles(Document doc){
		Elements elements = doc.getElementsByClass("title font16");
		ArrayList<String> titles = new ArrayList<>();
		for(Element element: elements){
			titles.add(element.text());
		}
		return titles;
	}
	public static ArrayList<String> getIngredientNames(Document doc2){
		Elements es = doc2.getElementsByClass("ingredient_name");
		ArrayList<String> names = new ArrayList<>();
		for(Element element :es){
			names.add(element.text());
		}
		return names;
	}
	public static ArrayList<String> getIngredientQuantites(Document doc2){
		Elements es = doc2.getElementsByClass("ingredient_quantity");
		ArrayList<String> quantities = new ArrayList<>();
		for(Element element :es){
			quantities.add(element.text());
		}
		return quantities;
	}
	public static int getSearchFoodNumber(String s, ArrayList<Food> list) {
		int key = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(s)) key = i;
		}
		return key;
	}
}