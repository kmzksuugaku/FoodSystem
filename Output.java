import java.util.ArrayList;
public class Output {
	public static void printTitle(String title){
		System.out.println("ƒŒƒVƒs–¼:" + title);
	}
	public static void printURL(String url){
		System.out.println("URL:" + url);
	}
	public static void printIngredients(ArrayList<String> names,ArrayList<String> quantities){
		for(int i = 0; i < names.size(); i++){
			int num = i + 1;
			System.out.println("Þ—¿" + num + ":" + names.get(i) + " " + quantities.get(i));
		}
	}
}