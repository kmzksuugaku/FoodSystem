public class RecipeUtils{
	public static void print(Recipe recipe){
		//���V�s��,���V�s��URL,���V�s�̍ޗ��\��\��
		Output.printTitle(recipe.getName());
		Output.printURL(recipe.getUrl());
		for(int i = 0; i < recipe.size(); i++) {
			int a = i + 1;
			System.out.println("�ޗ�" + a + ":" + recipe.get(i).getName() + " " + recipe.get(i).getQuantity());
		}
	}
}