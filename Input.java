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
		System.out.println("�I������ꍇ��press button��e����� ����ȊO��c�����");
		while(true){
			System.out.print("press button:");
			String input = sc.next();
			Food food = new Food();
			if(input.equals("e")) break;
			else {
				System.out.print("�H�ނ����:");
				String ingredient = sc.next();
				food.setName(ingredient);
				System.out.print("�ܖ������� �u�N �� ���v(��F2019 4 1)�����:");
				int year = sc.nextInt();//�N
				int month = sc.nextInt();//��
				int day = sc.nextInt();//��
				food.setTimeLimit(year,month,day);
				list.add(food);
			}
		}
		return list;
	}
}