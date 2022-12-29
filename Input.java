import java.util.ArrayList;
import java.util.Scanner;
public class Input {
	public static String getFood() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	public static ArrayList<Food> getInput(){
		ArrayList<Food> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("終了する場合はpress buttonにeを入力 それ以外はcを入力");
		while(true){
			System.out.print("press button:");
			String input = sc.next();
			Food food = new Food();
			if(input.equals("e")) break;
			else {
				System.out.print("食材を入力:");
				String ingredient = sc.next();
				food.setName(ingredient);
				System.out.print("賞味期限の 「年 月 日」(例：2019 4 1)を入力:");
				int year = sc.nextInt();//年
				int month = sc.nextInt();//月
				int day = sc.nextInt();//日
				food.setTimeLimit(year,month,day);
				list.add(food);
			}
		}
		return list;
	}
}