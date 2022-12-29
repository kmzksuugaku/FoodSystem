import java.util.ArrayList;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class SampleCode {
	public static void main(String[] args) throws IOException {
		//�V�X�e�����p�҂��H�ނƎ��Ԃ���́B���X�g���쐬�B
		ArrayList<Food> list = Input.getInput();
		//����
		StringBuffer search = SearchThings.getSearchName(list);
		//�������ʂ��X�N���C�s���O
		Document doc = Jsoup.connect("https://cookpad.com/recipe/list/10421939?utf8=%E2%9C%93&keyword=" + search).get();
		//�������ʂ��烌�V�s��URL�������擾
		ArrayList<String> urls = SearchThings.getURLs(doc);
		//�������ʂ��烌�V�s���������擾
		ArrayList<String> titles = SearchThings.getTitles(doc);
		
		RecipeList recipeList = new RecipeList();
		//���ʂ�\��
		for(int i = 0; i < urls.size(); i++) {
			//���V�s��URL��document���擾
			Document rs = Jsoup.connect(urls.get(i)).get();
			//�ޗ������擾
			ArrayList<String> names = SearchThings.getIngredientNames(rs);
			//�ޗ��̗ʂ��擾
			ArrayList<String> quantities = SearchThings.getIngredientQuantites(rs);
			
			Recipe recipe = new Recipe();
			//�ۑ��p�̃��V�s�ɑ��
			recipe.setList(Assign.getRecipeIngredients(names, quantities));
			recipe.setName(titles.get(i));
			recipe.setUrl(urls.get(i));
			//�ۑ��p�̃��V�s��ۑ��p�̃��V�s���X�g�ɑ��
			recipeList.add(recipe);
			
			//�\��
			RecipeUtils.print(recipe);
			System.out.println("");
		}
		//"�T�[�`�������e + List.xml"��ۑ�����
		String filename = search + "List.xml";
		RecipeListUtils.save(filename,recipeList);
	}
}