package Millionaire_Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Millionaire {

	private static Question[] questions;
	private static int count;
	
	public Millionaire(int number)
	{
		questions = new Question[number];
		count=0;
	}
	
	public void addQuestion(Question d)
	{
		questions[count] = d;
		count++;
	}
	
	public void addQuestion(String catagory, String text, String optionA,String optionB, String optionC, String optionD, String answer, String diff)
	{
		questions[count] = new Question(catagory, text, optionA,optionB,optionC,optionD,answer,diff);
		count++;
	}
	
	public void printAllQuestions()
	{
		for(int i=0;i<count;i++)
		{
			questions[i].display();
		}
	}
	public static void removeOption(String dc,int i) {
		if(dc.equals("A")) {
			questions[i].setOptionB("-");
			questions[i].setOptionC("-");
		}else if(dc.equals("B")) {
			questions[i].setOptionA("-");
			questions[i].setOptionC("-");
		}else if(dc.equals("C")) {
			questions[i].setOptionB("-");
			questions[i].setOptionD("-");
		}else if(dc.equals("D")) {
			questions[i].setOptionB("-");
			questions[i].setOptionC("-");
		}
	}
	public static void remove50(String v, String g, String dc) throws IOException {for(int i=0;i<count;i++)
	{			
		String questionText = questions[i].getText();
		questionText=questionText.toLowerCase();
		String questionSplitForQuestion[] = questionText.split(" ");
		for(int y =0; y<questionSplitForQuestion.length;y++) {
			int controlPunctuation=0;
			int c = questionSplitForQuestion[y].length()-1;
			File filePunctuation  = new File("noktalama.txt");
			BufferedReader readerPunctuationControl  = null;
			readerPunctuationControl = new BufferedReader(new FileReader(filePunctuation));
			String linePunctuation = readerPunctuationControl.readLine();
			String answerForUser = "";
			while(linePunctuation!=null) {	
				if(questionSplitForQuestion[y].charAt(c)==linePunctuation.charAt(0)) {
					String t2 = questionSplitForQuestion[y].substring(0, questionSplitForQuestion[y].length()-1);
					if(v.equals(t2) && g.equals(questions[i].getDiff())) {
						removeOption(dc,i);
						questions[i].display();
					}
					controlPunctuation++;
					break;
					}
				else {						
					linePunctuation = readerPunctuationControl.readLine();	
				}		
			}if(controlPunctuation==0) {
				if(v.equals(questionSplitForQuestion[y]) && g.equals(questions[i].getDiff())) {
					removeOption(dc,i);
					questions[i].display();					
				}
			}
		}
	}}
	
	public static String searchCatagory(String v, String g, String catagory) throws IOException {
		for(int i=0;i<count;i++)
		{			
			String catagories = "";
			String questionText = questions[i].getText();
			questionText=questionText.toLowerCase();
			String questionSplitForQuestion[] = questionText.split(" ");
			for(int y =0; y<questionSplitForQuestion.length;y++) {
				int controlPunctuation=0;
				int c = questionSplitForQuestion[y].length()-1;
				File filePunctuation  = new File("noktalama.txt");
				BufferedReader readerPunctuationControl  = null;
				readerPunctuationControl = new BufferedReader(new FileReader(filePunctuation));
				String linePunctuation = readerPunctuationControl.readLine();
				String answerForUser = "";
				while(linePunctuation!=null) {	
					if(questionSplitForQuestion[y].charAt(c)==linePunctuation.charAt(0)) {
						String t2 = questionSplitForQuestion[y].substring(0, questionSplitForQuestion[y].length()-1);
						if(v.equals(t2) && g.equals(questions[i].getDiff())) {							
							return questions[i].getCatagory();
						}
						controlPunctuation++;
						break;
						}
					else {						
						linePunctuation = readerPunctuationControl.readLine();	
					}		
				}if(controlPunctuation==0) {
					if(v.equals(questionSplitForQuestion[y]) && g.equals(questions[i].getDiff())) {
						return questions[i].getCatagory();
					}
				}
			}
		}
		return null;
	}
	
	
	public static String search(String v, String g, String dc) throws IOException {
		for(int i=0;i<count;i++)
		{			
			String questionText = questions[i].getText();
			questionText=questionText.toLowerCase();
			String questionSplitForQuestion[] = questionText.split(" ");
			for(int y =0; y<questionSplitForQuestion.length;y++) {
				int controlPunctuation=0;
				int c = questionSplitForQuestion[y].length()-1;
				File filePunctuation  = new File("noktalama.txt");
				BufferedReader readerPunctuationControl  = null;
				readerPunctuationControl = new BufferedReader(new FileReader(filePunctuation));
				String linePunctuation = readerPunctuationControl.readLine();
				String answerForUser = "";
				while(linePunctuation!=null) {	
					if(questionSplitForQuestion[y].charAt(c)==linePunctuation.charAt(0)) {
						String t2 = questionSplitForQuestion[y].substring(0, questionSplitForQuestion[y].length()-1);
						if(v.equals(t2) && g.equals(questions[i].getDiff())) {							
							questions[i].display();
							dc=questions[i].getAnswer();
							return dc;
						}
						controlPunctuation++;
						break;
						}
					else {						
						linePunctuation = readerPunctuationControl.readLine();	
					}		
				}if(controlPunctuation==0) {
					if(v.equals(questionSplitForQuestion[y]) && g.equals(questions[i].getDiff())) {
						questions[i].display();
						dc=questions[i].getAnswer();
						return dc;
					}
				}
			}
		}
		return dc;
	}
}
