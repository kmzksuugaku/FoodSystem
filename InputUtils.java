import java.util.ArrayList;
import java.io.File;
import javax.xml.bind.JAXB;

public class InputUtils {
	public static void print(ArrayList<Food> list){
		for(int i = 0; i < list.size(); i++){
			FoodUtils.print(list.get(i));
		}
	}
	public static void save(String filename, ArrayList<Food> list){
		File file = new File(filename);
		JAXB.marshal(list,file);
	}
	public static ArrayList<Food> load(String filename){
		File file = new File(filename);
		if(file.exists()){
			return JAXB.unmarshal(file,ArrayList<Food>.class);
		}
		return null;
	}
}