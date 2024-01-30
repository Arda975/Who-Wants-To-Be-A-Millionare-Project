package Millionaire_Project;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Contestant {
	
	private Name[] name;
	private CnDate[] birthCnDate;
	private Phone[] phonenumber;
	private Address[] address;
	static int count = 0;
	private static int totalQ = 0;
	private static int trueQ = 0;
	private static String nameMostSuccsesful ="";
	
	public Contestant(int count) {
		name = new Name[count];
		birthCnDate = new CnDate[count];
		phonenumber = new Phone[count];
		address = new Address[count];
		count = 0;
		
	}

	public Name[] getName() {
		return name;
	}

	public void setName(Name[] name) {
		this.name = name;
	}

	public void addData(Name n,CnDate d, Phone p , Address a) {
		name[count] = n;
		birthCnDate[count] = d;
		phonenumber[count] = p;
		address[count] = a;
		count++;
		
	}

	public void totalQuestionForContestans(int totalQ, int trueQ) throws IOException {
		File f = new File("Cons.txt");
		File fileWrite = new File("Cons.txt");
		FileWriter fileWriter = new FileWriter(fileWrite, true); 
		BufferedWriter bWriter = new BufferedWriter(fileWriter); 
		bWriter.write(totalQ + "#"+ trueQ );
		bWriter.newLine();
		bWriter.close();
	}
	
		public String randomContestants() throws IOException {
			Random rd = new Random();
			int random = rd.nextInt(count);
			
			String username = name[random].getName();
			String city=address[random].getCity();
			int userage =age(random);
			File f = new File("Cons.txt");
			File fileWrite = new File("Cons.txt");
			FileWriter fileWriter = new FileWriter(fileWrite, true); 
			BufferedWriter bWriter = new BufferedWriter(fileWriter); 
			bWriter.write(username + "#"+ userage +"#" +city +"#"); 
			bWriter.close();
			return name[random].display();
			
			
			
			
		}
	public int age(int temp) {

        Date zaman = new Date();
        DateFormat sD = new SimpleDateFormat("dd");
        DateFormat sM = new SimpleDateFormat("MM"); 
        DateFormat sY = new SimpleDateFormat("yyyy");
        int x = Integer.parseInt(sD.format(zaman));
        int y = Integer.parseInt(sM.format(zaman));
        int z = Integer.parseInt(sY.format(zaman));
 
        int a = birthCnDate[temp].getDay();
        int b = birthCnDate[temp].getMonth();
        int c = birthCnDate[temp].getYear();
        int dy, mth, yr;
        if(x<a){
        	dy = x - a +30;
            --y;
        }
        else
        	dy = x - a;
        if(y<b){
        	mth = y - b +12;
            --z;
        }
        else
        	mth = y - b;
        yr = z - c; 
       return yr;
	}
	
	public String printSuccesfulContestant() throws IOException {
		File fileControlCons  = new File("Cons.txt");
		int loop=0;
		BufferedReader readerRepeatCons  = null;
		readerRepeatCons = new BufferedReader(new FileReader(fileControlCons));
		String lineCons = readerRepeatCons.readLine();
		
		while(lineCons!=null) {
			String consSplit[] = lineCons.split("#");
			int maxSuccusfullInt = Integer.parseInt(consSplit[4]);
			if(maxSuccusfullInt==5) {
				nameMostSuccsesful =consSplit[0];
				loop=5;
				break;
			}else if(consSplit.length<3) {
				break;
			}
			lineCons = readerRepeatCons.readLine();	
			if(lineCons==null) {
				break;
			}	
	    }
		if(loop<5) {
			readerRepeatCons = new BufferedReader(new FileReader(fileControlCons));
			 lineCons = readerRepeatCons.readLine();
			while(lineCons!=null) {
				String consSplit[] = lineCons.split("#");
				int maxSuccusfullInt = Integer.parseInt(consSplit[4]);
				if(maxSuccusfullInt==4) {
					nameMostSuccsesful =consSplit[0];
					loop=4;
					break;
				}
				lineCons = readerRepeatCons.readLine();	
				if(lineCons==null) {
					break;
				}
		    }
		}if(loop<4) {
			readerRepeatCons = new BufferedReader(new FileReader(fileControlCons));
			 lineCons = readerRepeatCons.readLine();
			while(lineCons!=null) {
				String consSplit[] = lineCons.split("#");
				int maxSuccusfullInt = Integer.parseInt(consSplit[4]);
				if(maxSuccusfullInt==3) {
					nameMostSuccsesful =consSplit[0];
					loop=3;
					break;
				}
				lineCons = readerRepeatCons.readLine();	
				if(lineCons==null) {
					break;
				}
		    }
		}if(loop<3) {
			readerRepeatCons = new BufferedReader(new FileReader(fileControlCons));
			 lineCons = readerRepeatCons.readLine();
			while(lineCons!=null) {
				String consSplit[] = lineCons.split("#");
				int maxSuccusfullInt = Integer.parseInt(consSplit[4]);
				if(maxSuccusfullInt==2) {
					nameMostSuccsesful =consSplit[0];
					loop=2;
					break;
				}
				lineCons = readerRepeatCons.readLine();	
				if(lineCons==null) {
					break;
				}
		    }
		}if(loop<=2) {
			readerRepeatCons = new BufferedReader(new FileReader(fileControlCons));
			 lineCons = readerRepeatCons.readLine();
			while(lineCons!=null) {
				String consSplit[] = lineCons.split("#");
				int maxSuccusfullInt = Integer.parseInt(consSplit[4]);
				if(maxSuccusfullInt==1) {
					nameMostSuccsesful =consSplit[0];
					loop=1;
					break;
				}
				lineCons = readerRepeatCons.readLine();	
				if(lineCons==null) {
					break;
				}
		    }
		}
		return nameMostSuccsesful;
	
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Contestant.count = count;
	}
	public CnDate[] getBirthCnDate() {
		return birthCnDate;
	}

	public void setBirthCnDate(CnDate[] birthCnDate) {
		this.birthCnDate = birthCnDate;
	}

	public Phone[] getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Phone[] phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Address[] getAddress() {
		return address;
	}

	public void setAddress(Address[] address) {
		this.address = address;
	}
	

}
