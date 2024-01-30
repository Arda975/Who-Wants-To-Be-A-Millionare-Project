package Millionaire_Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Statistic {
	private String[] questionId;
	private String[] categoryId;
	private String[] isCorrrectAnswerId;
	private static int count=0;
	
	public void Statistic() {
		questionId = new String[count];
		categoryId = new String[count];
		isCorrrectAnswerId = new String[count];
		count=0;
		
	}
	public void addStatistic(String q, String cont, String cate, String isans) {
		questionId[count] =q;

		categoryId[count] = cate;
		isCorrrectAnswerId[count] = isans;
		
		count++;
		
		
	}
	public void contestants() throws IOException {
		File file = new File("Cons.txt");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		
	}
	public String[] getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String[] questionId) {
		this.questionId = questionId;
	}
	
	public String[] getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String[] categoryId) {
		this.categoryId = categoryId;
	}
	public String[] getIsCorrrectAnswerId() {
		return isCorrrectAnswerId;
	}
	public void setIsCorrrectAnswerId(String[] isCorrrectAnswerId) {
		this.isCorrrectAnswerId = isCorrrectAnswerId;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Statistic.count = count;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
