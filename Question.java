package Millionaire_Project;
import java.awt.Color;

import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class Question {
	public static enigma.console.Console cn = Enigma.getConsole("Millionaire");//, 120,50,12
	private String catagory;
	private String text;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private String diff;
	
	
public Question(String catagory, String text, String optionA, String optionB,String optionC, String optionD,String answer, String diff) {
		
		this.catagory = catagory;
		this.text = text;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.diff = diff;
	}
public void blue() {
	TextAttributes  write = new TextAttributes(Color.blue);
	cn.setTextAttributes(write);
}
public void green() {
	TextAttributes  write = new TextAttributes(Color.green);
	cn.setTextAttributes(write);
}
public void white() {
	TextAttributes  write = new TextAttributes(Color.white);
	cn.setTextAttributes(write);
}
		public void display(){
		blue();	
		System.out.print("Catagory: ");
		white();
		System.out.print(this.catagory);
		System.out.println();
		blue();
		System.out.print("Question: " );
		green();
		System.out.print( this.text);
		System.out.println();
		System.out.print("A): " +this.optionA); 
		System.out.println();
		System.out.print("B): " +this.optionB);
		System.out.println(); 
		System.out.print("C): " +this.optionC);
		System.out.println(); 
		System.out.print("D): " +this.optionD); 
		System.out.println(); 
		white();
		System.out.println("\n-----------------------------------------------------------------------------");
		System.out.println(); 
    }

public String getAnswer() {
	return answer;
}public String getCatagory() {
	return catagory;
}public String getDiff() {
	return diff;
}public String getOptionA() {
	return optionA;
}public String getOptionB() {
	return optionB;
}public String getOptionC() {
	return optionC;
}public String getOptionD() {
	return optionD;
}public String getText() {
	return text;
}public void setAnswer(String answer) {
	this.answer = answer;
}public void setCatagory(String catagory) {
	this.catagory = catagory;
}public void setDiff(String diff) {
	this.diff = diff;
}public void setOptionA(String optionA) {
	this.optionA = optionA;
}public void setOptionB(String optionB) {
	this.optionB = optionB;
}public void setOptionC(String optionC) {
	this.optionC = optionC;
}public void setOptionD(String optionD) {
	this.optionD = optionD;
}public void setText(String text) {
	this.text = text;
}
	

}
