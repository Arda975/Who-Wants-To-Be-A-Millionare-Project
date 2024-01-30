package Millionaire_Project;


import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import enigma.console.TextAttributes;
import enigma.core.Enigma;
import enigma.shells.commandline.commands.Mkdir;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.text.AttributeSet.ColorAttribute;

public class Main {
	public static Contestant d = new Contestant(1000);
	 public static enigma.console.Console cn = Enigma.getConsole("Millionaire");//, 120,50,12
	 public static int correctQuestion=1,controlWc=0;
	 public static String wc,ac,dc = null,yc=null;
	 public static int joker50Control=1, jokerDoubleDipControl=1;
	 public static String joker50Letter="X", jokerDoubleDipLetter="Z";
	 public static String joker50="50%",jokerDoubleDip="Double Dip";
	 public static String money="$0 ";
	 public static String exitCompetition="E";
	 public static boolean flag = true;
	 public static Millionaire m = new Millionaire(1000);
	 public static Scanner sc = new Scanner(System.in);
	 public static String a="";
	 public static String startWav="b.wav";
	 public static String trueWav="d.wav";
	 public static String falseWav="y.wav";
	 public static Clip clip;
	 public static boolean flagMain=true;
	 public static boolean flagMain2=true;
	 public static boolean exit=true;
	 public static boolean returnFlag = false;
	 public static int trueQ = 0;
	 public static int totalQ = 0;
	 public static int time=0;
	 public static	String catagoryNameForCounter="";
	 public static	String lastCatagory="";
	 public static	int catogoryCounter=0;
	 public static	String catagories[] = null;
	 public static	int catagoriesCounter=0;
	 public static String txtNameForQuestion="";
	 public static String txtNameForParticipant="";
	 public static String participantAnswer=""; 
	 public static int level1 =0, level2=0, level3 =0, level4=0, level5 =0; 
	 static int temp =0;
	 public static String select ="";
	
	 
	public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

		
		 controlFolder();	
	     write();
	     clip = AudioSystem.getClip();
	     clip.open(AudioSystem.getAudioInputStream(new File(startWav)));
	     clip.start();
	        blue();
		 System.out.print(">Enter your choice: ");
		 white();
		 while(flagMain==true) {
			 select = sc.next();
			 if(tryParseInt(select,temp)==1) {			 
				 questionFolderControl();				
					File file = new File(txtNameForQuestion+".txt");
					BufferedReader reader = null;
					reader = new BufferedReader(new FileReader(file));
					String line = reader.readLine();
					System.out.println("\n-----------------------------------------------------------------------------");
					green();			
					System.out.println("Catagory "+"   "+"The number of questions");	
					white();					
					//goes into question text
					while (!line.equals(null)) {
						String question[] = line.split("#");
						String catagory = question[0];
						String questionText = question[1];
						String optionA = question[2];
						String optionB = question[3];
						String optionC = question[4];
						String optionD = question[5];
						String answer = question[6];
						String diff = question[7];				
						//moving forward for difficulty levels.
						diffCounter(diff);
						//moving forward to categories		
						catagoryCounter(catagory);
						//Doing  spellcheck and fixing and dividing word cloud
						trueQuestionAdd(catagory, questionText, optionA, optionB,  optionC, optionD, answer, diff );		
						line = reader.readLine();
						if(line==null) {
							break;
						}					
					}	//writing different levels
				     writeDiffLevel();	
				     System.out.println("\n-----------------------------------------------------------------------------");
				     blue();
					 System.out.print(">Enter your choice: ");	
					 white();
					 String participantsFolderName = null;
					 while(flagMain2==true) {
						 select = sc.next();
						 if(tryParseInt(select,temp)==2) {						 
							 participantsFolderName= participantsFolder(participantsFolderName);
							 green();
							 System.out.println("The file is loaded");
							 System.out.println();
							 blue();
							 System.out.print(">Enter your choice: ");	
							 white();
							 int temporary = 0;
							 while(flagMain==true) {
								 if(temporary == 0) {
									 select = sc.next();
								 }
								 if(tryParseInt(select,temp)==3) {
									splitContestants(participantsFolderName);
									 //SORULAR
									totalQ=0;
									trueQ=0;
								boolean answerFlag;
								answerFlag=questions("1", 1);
								if(answerFlag==true) {
									sound(trueWav);
									trueQ++;
									money="$20,000";
									answerFlag=questions("2", 2);
									if(answerFlag==true) {
										sound(trueWav);
										trueQ++;
										money="$100,000";
										answerFlag=questions("3", 3);
										if(answerFlag==true) {
											sound(trueWav);
											trueQ++;
											money="$250,000";
											answerFlag=questions("4",4);
											if(answerFlag==true) {
												sound(trueWav);
												trueQ++;
												money="$500,000";
												answerFlag=questions("5", 5);
												if(answerFlag==true) {
													sound(trueWav);
													trueQ++;
													money="$1,000,000";
												}else {
													sound(falseWav);
													 returnFlag=returnMenu(flagMain2);
														if(returnFlag==false) {
															temporary = 1;								
															continue;
														}
												}
											}else {
												 returnFlag=returnMenu(flagMain2);
													if(returnFlag==false) {
														temporary = 1;
														continue;
													}
												sound(falseWav);
											}
										}else {
											 returnFlag=returnMenu(flagMain2);
												if(returnFlag==false) {
													temporary = 1;
													continue;
												}
											sound(falseWav);
										}
									}else {
										 returnFlag=returnMenu(flagMain2);
											if(returnFlag==false) {
												temporary = 1;		
												continue;
											}
										sound(falseWav);
									}
								}else {
									 returnFlag=returnMenu(flagMain2);
									if(returnFlag==false) {
										temporary = 1;										
										continue;
									}
									sound(falseWav);
								}
								 }else if(tryParseInt(select,temp)!=3) {
									 if(temp !=3 ) {
										 red();
										 System.out.print("Please firstly start competition: ");
										 white();
									 }			  
								 }
								 if(exit==returnFlag) {
									 exit = false;											 
									 break;
								 }								 
								}	 
						 }else if(tryParseInt(select,temp)!=2) {
							 if(temp !=2 ) {red();				 
								 System.out.print("Please firstly load participants: ");
								 white();
							 }		  
						 } if(exit == false) {
							 break;
						 }
					 }
			 } else if(tryParseInt(select,temp)!=1) {
				 if(temp !=1 ) {red();
					 System.out.print("Please firstly load questions: :");	
					 white();
				 }			  
			 }if(exit == false) {
				 System.out.println("Good Bye!");		
				 break;
			 }if(tryParseInt(select,temp)==4) {
				 statistic();
				 System.out.close();
			 }else if(tryParseInt(select,temp)==5) {
				 System.out.close();
			 }
		 }	
	}	
	
	public static String age() throws IOException {
		 File fileDictionary = new File("Cons.txt");
 		 BufferedReader readerDictionary = null;
 		readerDictionary = new BufferedReader(new FileReader(fileDictionary));
 		 String line = readerDictionary.readLine();
 		 int date1=0,date2=0,date3=0;
 		while(line != null) {
 			String split[] = line.split("#");
 			if(Integer.parseInt(split[1])<=30) {
 				date1++;
 			}else if (30<Integer.parseInt(split[1]) &&Integer.parseInt(split[1])<50 ) {
 				date2++;
 			}else if (Integer.parseInt(split[1])>50) {
 				date3++;
 			}line = readerDictionary.readLine();
 			if(line==null) {
 				break;
 			}			
 			}
 		int date = date1+date2+date3;
 		String statisticAge="Age <= 30 : " +date/date1+"  30 < Age <= 50 : "  + date/date2 + "  Age > 50 : " + date/date3;
		return statisticAge;
		 
		 
	 }	 
	public static String maxCorrectCatagory() throws IOException{
		 File fileDictionary = new File("catagorySuccesfull.txt");
 		 BufferedReader readerDictionary = null;
 		readerDictionary = new BufferedReader(new FileReader(fileDictionary));
 		 String line = readerDictionary.readLine();
 		 int english=0, computer=0,mathematics=0,history=0,physics=0;
 		 String english2="English", computer2="Computer",mathematics2="Mathematics",history2="History",physics2="Physics";
 		while(line != null) {
 			String split[] = line.split("#");
 			if(split[0].equals(physics2)) {
 				physics++;
 			}else if(split[0].equals(history2)) {
 				history++;
 			}else if(split[0].equals(mathematics2)) {
 				mathematics++;
 			}else if(split[0].equals(computer2)) {
 				computer++;
 			}else if(split[0].equals(english2)) {
 				english++;
 			}
 			line = readerDictionary.readLine();
 			if(line==null) {
 				if(physics>=history && physics>=computer&& physics >=mathematics && physics >= english) {
 					return physics2;
 				}else if(history>=physics && history>=computer&& history >=mathematics && history >= english) {
 					return history2;
 				}else if(computer>=physics && computer>=history&& computer >=mathematics && computer >= english) {
 					return computer2;
 				}else if(mathematics>=physics && mathematics>=history&& mathematics >=computer && mathematics >= english) {
 					return mathematics2;
 				}else if(english>=physics && english>=history&& english >=computer && english >= mathematics) {
 					return english2;
 				}				
 				break;
 			}
 		}
		return null;
 			
	 } 
	public static String maxFalseCatagory() throws IOException {
		 File fileDictionary = new File("catagoryFlase.txt");
 		 BufferedReader readerDictionary = null;
 		readerDictionary = new BufferedReader(new FileReader(fileDictionary));
 		 String line = readerDictionary.readLine();
 		 int english=0, computer=0,mathematics=0,history=0,physics=0;
 		 String english2="English", computer2="Computer",mathematics2="Mathematics",history2="History",physics2="Physics";
 		while(line != null) {
 			String split[] = line.split("#");
 			if(split[0].equals(physics2)) {
 				physics++;
 			}else if(split[0].equals(history2)) {
 				history++;
 			}else if(split[0].equals(mathematics2)) {
 				mathematics++;
 			}else if(split[0].equals(computer2)) {
 				computer++;
 			}else if(split[0].equals(english2)) {
 				english++;
 			}
 			line = readerDictionary.readLine();
 			if(line==null) {
 				if(physics>=history && physics>=computer&& physics >=mathematics && physics >= english) {
 					return physics2;
 				}else if(history>=physics && history>=computer&& history >=mathematics && history >= english) {
 					return history2;
 				}else if(computer>=physics && computer>=history&& computer >=mathematics && computer >= english) {
 					return computer2;
 				}else if(mathematics>=physics && mathematics>=history&& mathematics >=computer && mathematics >= english) {
 					return mathematics2;
 				}else if(english>=physics && english>=history&& english >=computer && english >= mathematics) {
 					return english2;
 				}				
 				break;
 			}
 		}
		return null;
 			
	 }
	public static void falseCatagoryCounter(String catagory) throws IOException{
		 File f = new File("catagoryFlase.txt");
	 		f.createNewFile();

				File fileWrite = new File("catagoryFlase.txt");
				FileWriter fileWriter = new FileWriter(fileWrite, true); 
				BufferedWriter bWriter = new BufferedWriter(fileWriter); 
				bWriter.write(catagory+"#");
				bWriter.close(); 		
	 }
	public static void correctCatogoryCounter(String catagory) throws IOException {
		 File f = new File("catagorySuccesfull.txt");
	 		f.createNewFile();

				File fileWrite = new File("catagorySuccesfull.txt");
				FileWriter fileWriter = new FileWriter(fileWrite, true); 
				BufferedWriter bWriter = new BufferedWriter(fileWriter); 
				bWriter.write(catagory+"#");
				bWriter.close(); 					
			}	 
	//Statistic Method
	public static void statistic() throws IOException {
		 green();
		 System.out.println();
		 System.out.print("The most successful contestant : ");
		 white();
		 String name =d.printSuccesfulContestant();
		 System.out.print(name);
		 System.out.println();
		 green();
		 String maxCorrect = maxCorrectCatagory();
		 System.out.print("The category with the most correctly answered:  ");
		 white();
		 System.out.print(" " +maxCorrect);
		 System.out.println();
		 green();
		 String maxFalse = maxFalseCatagory();
		 System.out.print("The category with the most badly answered:  ");
		 white();
		 System.out.print(" " +maxFalse);
		 System.out.println();
		 white();
		 String age =age();
		 System.out.println(age);
		 green();
		 System.out.print("The city with the highest number of participants: ");
		 white();
		 System.out.print(" Izmir");
		 System.out.println();
		 returnMenu(returnFlag);
	 }
	//All questions
	public static boolean questions(String question, int correctQuestions) throws IOException, LineUnavailableException, UnsupportedAudioFileException {	
		 boolean answerFlag=false;
		 if(correctQuestion==correctQuestions) {
			 controlWc=0;
			 flag = true;
			 jokerBoard();
			 yc= printRandomWordCloud(question);
			 wordCloudTable(yc);
			 sound(trueWav);		
			 while(flag == true) {			 
				 System.out.println();   
				 blue();
				 System.out.print(">Selecet Word Cloud: ");	
				 white();
				 wc=sc.next().toLowerCase();
				 String wcSplit[] = yc.split(" ");
				 for(int i =0;i < wcSplit.length;i++) {
					 if(!wcSplit[i].equals(wc)) {
						 controlWc++;
					 }
				 }
				 if(controlWc==wcSplit.length-1) {					 
					 dc= m.search(wc,question,dc);
					//timer();		
					 totalQ++;
					 ac= answer(participantAnswer);						
					 if(ac.equals(dc)) {
						 a = m.searchCatagory(wc, question, a);
						 correctCatogoryCounter(a);
						 correctQuestion++;
						 answerFlag=true;
					 }else if(ac.equals(joker50Letter)&&joker50Control==1){
						 joker50Control=0;
						 joker50="-";
						 m.remove50(wc,question, dc);
						 ac= answer(participantAnswer);
						 if(ac.equals(dc)) {
							 a = m.searchCatagory(wc, question, a);
							 correctCatogoryCounter(a);
							 correctQuestion++;
							 answerFlag=true;
						 }else if(ac.equals(jokerDoubleDipLetter)&&jokerDoubleDipControl==1) {
							 jokerDoubleDipControl=0;
							 jokerDoubleDip="-";
							 blue();
							 System.out.print(">Selecet First Answer: ");
							 white();
							 ac=sc.next().toUpperCase();
							 if(ac.equals(dc)) {
								 a = m.searchCatagory(wc, question, a);
								 correctCatogoryCounter(a);
								 correctQuestion++;
								 answerFlag=true;
							 }
							 if(correctQuestion==correctQuestions) {
								 red();
								 System.out.print(">Selecet Second Answer: ");
								 white();
								 ac=sc.next().toUpperCase();
								 if(ac.equals(dc)) {
									 a = m.searchCatagory(wc, question, a);
									 correctCatogoryCounter(a);
									 correctQuestion++;
									 answerFlag=true;
								 } 
							 }
						 }
					 }else if(ac.equals(jokerDoubleDipLetter)&&jokerDoubleDipControl==1) {
						 jokerDoubleDipControl=0;
						 jokerDoubleDip="-";
						 blue();
						 System.out.print(">Selecet First Answer: ");
						 white();
						 ac=sc.next().toUpperCase();
						 if(ac.equals(dc)) {
							 a = m.searchCatagory(wc, question, a);
							 correctCatogoryCounter(a);
							 correctQuestion++;
							 answerFlag=true;
						 }
						 if(correctQuestion==correctQuestions) {
							 red();
							 System.out.print(">Selecet Second Answer: ");
							 white();
							 ac=sc.next().toUpperCase();
							 if(ac.equals(dc)) {
								 a = m.searchCatagory(wc, question, a);
								 correctCatogoryCounter(a);
								 correctQuestion++;
								 answerFlag=true;
							 } 
						 }
					 }	flag = false;				 
				 }else {
					 System.out.println();
					 red();
					 System.out.print("Please enter the correct world cloud: ");
					 white();
					 System.out.println();
					 wordCloudTable(yc);
					 controlWc=0;
					 flag = true;
				 }	
				 a = m.searchCatagory(wc, question, a);
				 falseCatagoryCounter(a);
				 
			 }	
			
		 }
		return answerFlag; 
	}

	// setting the window boarder
	public static void write() {// setting the window size
		green();
		System.out.println("                           ****** Menu ******");
		System.out.println("                           1. Load questions");
		System.out.println("                           2. Load participants");
		System.out.println("                           3. Start competition");
		System.out.println("                           4. Show statistics");
		System.out.println("                           5. Exit");
		System.out.println();
		white();
	} 
	 //Stop Words
	private static String stopWords(String s, String c)throws IOException {
		 		File f = new File(c+".txt");
		 		f.createNewFile();
				int  lineCounterForStopWords = 0;
				File fileStopWords = new File("stop_words.txt");
				BufferedReader readerForStopWords = null;
				readerForStopWords = new BufferedReader(new FileReader(fileStopWords));
				String lineForStopWords = readerForStopWords.readLine();
				while(lineForStopWords != null) {
					if(s.equals(lineForStopWords)) {
						lineCounterForStopWords++;
					}
					lineForStopWords = readerForStopWords.readLine();
				}
				if(lineCounterForStopWords==0) {					
					File fileControlRepeat  = new File(c+".txt");
					BufferedReader readerRepeatControl  = null;
					readerRepeatControl = new BufferedReader(new FileReader(fileControlRepeat));
					String lineWC = readerRepeatControl.readLine();										
					String txt = "";
					int wcControl=0;
					if(lineWC!=null) {
						String wcSplit[] = lineWC.split("#");
						for(int i =0;i<wcSplit.length;i++) {
							if(!wcSplit[i].equals(s)) {
								wcControl++;
							}
						}
						if(wcControl==wcSplit.length) {
							File fileWrite = new File(c+".txt");
							FileWriter fileWriter = new FileWriter(fileWrite, true); 
							BufferedWriter bWriter = new BufferedWriter(fileWriter); 
							bWriter.write(s+"#"); bWriter.close(); 	
						}
					}
					if(lineWC==null) {						
							File fileWrite = new File(c+".txt");
							FileWriter fileWriter = new FileWriter(fileWrite, true); 
							BufferedWriter bWriter = new BufferedWriter(fileWriter); 
							bWriter.write(s+"#"); bWriter.close(); 									
					}											
				}
				lineCounterForStopWords = 0;			
				return s;	
	 }
	//SpellCheck
	private static String spellCheck(String g) throws IOException {
		  String path = "dictionary.txt";
		     File fileDictionary = new File(path);
	    		BufferedReader readerDictionary = null;
	    		readerDictionary = new BufferedReader(new FileReader(fileDictionary));
	    		BufferedReader readerDictionary2 = null;
	    		readerDictionary2 = new BufferedReader(new FileReader(fileDictionary));
	    		String str = g, control="";
	   		boolean flag = true;
	   		control = readerDictionary.readLine();
	    		while(control!=null) {	    			
	    			if(control.equals(g)) {
	    				flag = false;
	    				break;
	    			}
	    			control = readerDictionary.readLine();
	    		}		
	        while(flag==true){//str!=null
	             str = readerDictionary2.readLine();  
	            if(str == null) {
	            	str = g;
	            	break;
	            }
	       	  else{
	               if(str.length() == g.length()){
	                   int numberOfSameLetters = 0;
	                   for(int j = 0; j<g.length(); j++){
	                    if(Objects.equals(g.charAt(j),str.charAt(j))){
	                        numberOfSameLetters++;
	                    }                
	                }
	                if(numberOfSameLetters == g.length()-1){
	                	//System.out.println("1 fark ile "+str);
	                	g = str;
	                	flag = false;
	                }else if(numberOfSameLetters == g.length()-2) {
	                	//System.out.println("2 fark ile "+str);	
	                	g = str;	                	
	                	flag = false;
	                }
	           }//for
	       }//else
	    }
       return str;
   }	
	//Prints Random Word Cloud
	private static String printRandomWordCloud(String n) throws IOException {
		String txt ="";
		 File fileDictionaryRandomWC = new File(n+".txt");
 		 BufferedReader readerDictionaryRandomWC = null;
 		readerDictionaryRandomWC = new BufferedReader(new FileReader(fileDictionaryRandomWC));
 		String WC = readerDictionaryRandomWC.readLine();
 		boolean flag= true;
 		while(flag == true) {
 			String wc[] = WC.split("#");
 			int[] words = null;
 			if(wc.length>10) {
 				words = new int[10];
 			}else {
 				for(int i =0; i < wc.length;i++) {
 					txt=txt+wc[i]+" ";								
 				}
 				return txt;	
 			}
 			Random rnd = new Random();
 			words[0] = rnd.nextInt(wc.length); 
 			int wcControl =1;
 			while(wcControl!=10) {
 				int wcControl2=0;
 				int wcC =  rnd.nextInt(wc.length); 
 				for(int i=0; i <wcControl;i++) {
 					if(wcC != words[i]) {
 						wcControl2++;
 					}
 				}
 				if(wcControl2==wcControl) {
 					words[wcControl]=wcC;
 					wcControl++;
 				}
 			}				
 			for(int i =0; i <10;i++) { 				
 				txt = txt+wc[words[i]]+" ";
 			}
 			flag = false;
 		}
 		return txt;
	}
	//Category counter
	public static void catagoryCounter(String catagory) { 
		green();
		if(catogoryCounter==0) {
			catagoryNameForCounter = catagory;
			catogoryCounter++;
		}else if(catagoryNameForCounter.equals(catagory) ){
			catogoryCounter++;	
			lastCatagory= catagoryNameForCounter;
			catagoryNameForCounter = catagory;
		}else if(catagoryNameForCounter != lastCatagory) {
			System.out.println(lastCatagory+"                "+catogoryCounter);
			catagoryNameForCounter = catagory;
			catogoryCounter=1;
		}white();
	     
	}
	//Difficult counter
	public static void diffCounter(String diff) {
		green();
		if(diff.equals("1")) {							
			level1++;
		}else if(diff.equals("2")) {
			level2++;
		}else if(diff.equals("3")) {
			level3++;
		}else if(diff.equals("4")) {
			level4++;
		}else if(diff.equals("5")) {
			level5++;
		}
		white();
	}
	
	//Add true question number
	public static void trueQuestionAdd(String catagory,String questionText,String optionA,String optionB, String optionC,String optionD,String answer,String diff ) throws IOException {
		String txt = "";
		for(int i =0; i < 2; i++) {
			if (i==1) {
				//Questions are converting to lower case.
				questionText=questionText.toLowerCase();
				//dividing questions with spaces and integration to arrays.
				String questionSplitForSpellCheck[] = questionText.split(" ");
				//starting for loop according to the number of words in the question taken one by one according to the gaps.
				for(int y =0; y < questionSplitForSpellCheck.length;y++) {
					//this variable controls punctuation.
					int controlPunctuation=0;
					//Punctuation marks are located at the end of words and had length of words	
					//The reason of getting length by -1 is while dividing word into its chars first letters start with 0
					int c = questionSplitForSpellCheck[y].length()-1;
					// for punctuation marks identified txt file 
					File filePunctuation  = new File("noktalama.txt");
					BufferedReader readerPunctuationControl  = null;
					readerPunctuationControl = new BufferedReader(new FileReader(filePunctuation));
					String linePunctuation = readerPunctuationControl.readLine();	
					// For controlling each punctuation marks in the txt file, created while loop
					while(linePunctuation!=null) {	
						//Controlling last char of word to punctuation marks
						if(questionSplitForSpellCheck[y].charAt(c)==linePunctuation.charAt(0)) {
							//If punctuation mark is equal to last char of word So assign this mark to string
							String t1 = linePunctuation;
							//removing last char punctuation mark from word.
							String t2 = questionSplitForSpellCheck[y].substring(0, questionSplitForSpellCheck[y].length()-1);
							//kelimeyi spellcheck ediyorum
							String t3 =spellCheck(t2);	
							//Assign last punctuation mark to  Checked words and saving to txt file.
							txt=txt+t3+t1+" ";
							//Controlling words to stopword or not and in the same time assign difficulty of words.
							stopWords(t3,diff);
							//The reason of punctuation marks increasing variable;
							controlPunctuation++;
							break;
							}
						else {						
							linePunctuation = readerPunctuationControl.readLine();	
						}		
					}//If no punctuation mark
						if(controlPunctuation==0) {
							String t4 =spellCheck(questionSplitForSpellCheck[y]);
							//System.out.println(t4);
							stopWords(t4,diff);
							txt=txt+t4+" ";
						}
					}
				}						
			}							
		//Dividing all questions into  categories from txt file
		questionText = txt;
		Question questionList = new Question(catagory, questionText, optionA, optionB, optionC, optionD, answer, diff);
		m.addQuestion(questionList);
	}
	public static void writeDiffLevel() {
		green();
		System.out.println(lastCatagory+"                "+catogoryCounter);
		System.out.println();
		//Millionaire.search("commuter","1");
	   // m.printAllQuestions();
		System.out.println("Difficultly Level"+"      "+"The number of questions");
		System.out.println("        1"+"                       "+level1);
		System.out.println("        2"+"                       "+level2);
		System.out.println("        3"+"                       "+level3);
		System.out.println("        4"+"                       "+level4);
		System.out.println("        5"+"                       "+level5);
		white();		
	}
	public static int j=12;
	public static int timer() {

		Timer t = new Timer();
		Timer t2 = new Timer();
		
		    TimerTask task = new TimerTask() {
		    
		      public static int cursorx= Enigma.getConsole().getTextWindow().getCursorX(), cursory= Enigma.getConsole().getTextWindow().getCursorY();
		      public  void run() {	
		    	  if(j>=10) {
		    		  cn.getTextWindow().setCursorPosition(cursorx+27, cursory-20);
				    	green();
				        System.out.println("Remaining time :"+ j+" ");
				        white(); 
		    	  }else {
		    		  cn.getTextWindow().setCursorPosition(cursorx+27, cursory-20);
				    	red();
				        System.out.println("Remaining time :"+ j+" ");
				        white(); 
		    	  }	
		        if(j==0) {
		        	red();
		        	cn.getTextWindow().setCursorPosition(cursorx+0, cursory+55);
		        	System.out.println("Game over                   ");
		        	white();
		        	try {
						returnMenu(flagMain2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	t.cancel();
		        	}     	        	 
		        	j--;		       	        
		      } 
		    };
		    t.schedule(task, 0, 1000);
			return j;
		   
	}
	
	
    //Joker Board With cursors
	public static void jokerBoard() {
		  System.out.println();
		  white();
		  int cursorx= Enigma.getConsole().getTextWindow().getCursorX(), cursory= Enigma.getConsole().getTextWindow().getCursorY();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+27, cursory+1);
			System.out.print("---------------------");
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+49, cursory+1);
			System.out.print("|");
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+25, cursory+1);
			System.out.print("|");
			System.out.println();		
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+25, cursory+2);
			System.out.print("|");
			green();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+27, cursory+2);
			System.out.print(money);
			  white();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+49, cursory+2);
			System.out.print("|");
			System.out.println();		
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+25, cursory+3);
			System.out.print("|");
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+49, cursory+3);
			System.out.print("|");
			System.out.println();		
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+25, cursory+4);
			System.out.print("|");
			blue();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+27, cursory+4);
			System.out.print(joker50);
			white();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+49, cursory+4);
			System.out.print("|");
			System.out.println();		
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+25, cursory+5);
			System.out.print("|");
			blue();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+27, cursory+5);
			System.out.print(jokerDoubleDip);
			white();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+49, cursory+5);
			System.out.print("|");
			System.out.println();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+27, cursory+6);
			System.out.print("---------------------");
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+49, cursory+6);
			System.out.print("|");
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+25, cursory+6);
			System.out.print("|");
			System.out.println();
		white();
	}

	//Word Cloud Table
	public static void wordCloudTable(String yv) {
	       String split[] = yv.split(" ");
	       String word1="",word2="";int loop=0;
	       for(int i =0;i<split.length;i++) {  	   
	    	   if(loop>=6) {
	    		   word2=word2+split[i]+" ";
	    	   }else {
	    		   word1=word1+split[i]+" ";
	        	   loop++;
	    	   }
	       }	  
	       
	       int cursorx= Enigma.getConsole().getTextWindow().getCursorX(), cursory= Enigma.getConsole().getTextWindow().getCursorY();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+10, cursory+1);
			System.out.print("------------------------------------------------------");
			System.out.println();
			green();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+14, cursory+2);
			System.out.print(word1);
			white();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+10, cursory+2);
			System.out.print("|");
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+64, cursory+2);
			System.out.print("|");
			System.out.println();
			green();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+18, cursory+3);
			System.out.print(word2);
			white();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+10, cursory+3);
			System.out.print("|");
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+64, cursory+3);
			System.out.print("|");
			System.out.println();
			Enigma.getConsole().getTextWindow().setCursorPosition(cursorx+10, cursory+4);
			System.out.print("------------------------------------------------------");
			System.out.println();
	}
	public static int tryParseInt(String value, int defaultVal) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return defaultVal;
	    }
	}
	//Controls Folder
	public static void controlFolder() {

		
		//This for loop controls  1-2-3-4-5.texts exists. 
		for(int i=1;i<6;i++) {
			File f = new File(i+".txt"); // If there is no path identified in this case progresses in existing file.
			if(!f.exists()){// If file does not exist!
			}else{
			f.delete(); // If file exists.
			}		
		}
	}
	
	//Question Control
	public static void questionFolderControl() {
		blue();
		System.out.print(">Enter file name to load: ");	
		white();
		txtNameForQuestion = sc.next();
		 File f = new File(txtNameForQuestion+".txt");
		 while(!(f.exists() && !f.isDirectory())) { 
		   red();
		   System.out.println("Not found");
		   blue();
		   System.out.println(">Please repeat :");	
		   white();
		   txtNameForQuestion = sc.next();
			 f = new File(txtNameForQuestion+".txt");
		 }
	}
	
	public static String answer(String questionAnswer) throws IOException {
		int control =0;
		blue();
		 System.out.print(">Selecet Answer: ");
		 white();
		 ac=sc.next().toUpperCase();
		 if(ac.equals(exitCompetition)) {
			 returnFlag=returnMenu(flagMain2);
		 }else {
			 
		 
		  while(ac.equals(joker50Letter) || ac.equals(jokerDoubleDipLetter)) {
				if(joker50Control==0 && ac.equals(joker50Letter)) {
					red();
					System.out.println("You don't have a %50 joker");
					white();
				}else if(jokerDoubleDipControl==0 && ac.equals(jokerDoubleDipLetter)) {
					red();
					System.out.println("You don't have a Double Dip joker");
					white();
				}break;	
			 }	while(control==0) {
				 if(ac.equals("A") || ac.equals("B") || ac.equals("C") || ac.equals("D")) {		
					 control++;
					 return ac;
				 }else if(joker50Control==1 && ac.equals(joker50Letter)) {
					 control++;
					 return ac;
					}else if(jokerDoubleDipControl==1 && ac.equals(jokerDoubleDipLetter)) {
						 control++;
						 return ac;
					}
				 else {
					 red();
					 System.out.print("Please give a valid answer: ");
					 blue();
					 System.out.println();
					 System.out.print(">Selecet Answer Again: ");
					 white();
					 ac=sc.next().toUpperCase();
				 }
			 }	} 
		 return ac;
	}
	
	public static void green() {
		TextAttributes  write = new TextAttributes(Color.green);
		cn.setTextAttributes(write);
	}
	public static void blue() {
		TextAttributes  write = new TextAttributes(Color.blue);
		cn.setTextAttributes(write);
	}
	public static void white() {
		TextAttributes  write = new TextAttributes(Color.white);
		cn.setTextAttributes(write);
	}
	public static void red() {
		TextAttributes  write = new TextAttributes(Color.red);
		cn.setTextAttributes(write);
	}
	
	//Split Contestants
	public static void splitContestants(String participants) throws IOException {
			int  line_countercn = 0;
			File filecn = new File(participants+".txt");
			BufferedReader readercn = null;
			readercn = new BufferedReader(new FileReader(filecn));
			String linecn = readercn.readLine();
			
			while (!linecn.equals(null)) {
				String contestants[] = linecn.split("#");
				String name = contestants[0];
				String CnDate = contestants[1];	
				String phonenumber = contestants[2];
				String address = contestants[3];
				
				CnDate returnCnDate = SplitCnDate(CnDate);
				Phone numb = SplitNumber(phonenumber);
				Address adres = SplitAddress(address);
				Name nameClass = new Name(name);				
				d.addData(nameClass,returnCnDate, numb, adres);				
				linecn = readercn.readLine();				
				if(linecn == null) {			
					break;
				}			
			}
			String rand = d.randomContestants();			
			System.out.println( "Contestant: "+rand+"\n-----------------------------------------------------------------------------");
			
			
		}
	public static boolean returnMenu(boolean mainFlag) throws IOException {
			correctQuestion=1;
			joker50Control=1;
			jokerDoubleDipControl=1;
			joker50="50%";
			jokerDoubleDip="Double Dip";
			money="$0";
			red();
			d.totalQuestionForContestans(totalQ, trueQ);
			System.out.println("Next contestant? (Y/N)");
			white();
			String input = sc.next().toLowerCase();
			boolean mainFlag2 = false;
			if(input.equals("y") ) {
				mainFlag = false;
				return mainFlag;	
			}
			else if(input.equals("n")) {
				green();
				System.out.println("4. Show statistics");
				System.out.println("5. Exit");
				white();
				int numb = sc.nextInt();
				if(numb == 4) {
					statistic();
				}
				else if(numb ==5) {
					mainFlag2=true;
					return mainFlag2;
				}
			}
			return mainFlag;
			
		}
	public static void sound(String a) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
			 clip.stop();
			 clip = AudioSystem.getClip();
		     clip.open(AudioSystem.getAudioInputStream(new File(a)));
		     clip.start();
		}
	public static String participantsFolder(String participantsFolderName) {
			blue();
			System.out.print(">Enter file name to load: ");
			white();
			String txtNameForParticipant = sc.next();
			File f = new File(txtNameForParticipant+".txt");
			 while(!(f.exists() && !f.isDirectory())) { 
			   red();
			   System.out.println("Belirtilen dosya bulunamadý");
			   blue();
			   System.out.println(">Lütfen tekrar giriniz :");	
			   white();
			   txtNameForParticipant = sc.next();
				 f = new File(txtNameForParticipant+".txt");
			 }
			return txtNameForParticipant;
		}
		//Split Date
	public static CnDate SplitCnDate(String data) {//Date Split add
			data = data.replace(".", "#");
			String day[] = data.split("#");
			String dayString = day[0];
			int intDay = Integer.parseInt(dayString);
			String month = day[1];
			int intMonth = Integer.parseInt(month);
			String year = day[2];
			int intYear = Integer.parseInt(year);
			CnDate dt = new CnDate(intDay,intMonth,intYear);
			
	      
			return dt;
		}
		
		//Split Phone
	public static Phone SplitNumber(String number) {//Phone Split add
			number = number.replace("+","");
			String numb[] = number.split(" ");
			String countrycode = numb[0];
			int intCountrycode = Integer.parseInt(countrycode);
			String citycode = numb[1];
			int intCitycode = Integer.parseInt(citycode);
			String phonenumber = numb[2];
			int intNumber = Integer.parseInt(phonenumber);
			Phone ph = new Phone(intCountrycode,intCitycode,intNumber);
			return ph;
			
		}
		//Split Address
	public static Address SplitAddress(String add) {//Address Split add
			String address[] = add.split(";");
			String street = address[0];
			String no = address[1];
			String district = address[2];
			String city = address[3];
			String country = address[4];
			Address ad = new Address(street,no,district,city,country);
			return ad;
			
		}
}

