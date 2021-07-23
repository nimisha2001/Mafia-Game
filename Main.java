package sem3;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game_Mafia {
	static int N;
	static Mafia[] marr;
	static Detective[] darr;
	static Healer[] harr;
	static Commoner[] carr;
	static int m_no,d_no,h_no,c_no;
	static Player[] arr;

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Welcome to Mafia\r\n" + 
				"Enter Number of players:");
	
		int c=0;
		while(c==0)
		{try { input=new Scanner(System.in); N=input.nextInt(); c=1;}
		catch(InputMismatchException ex) { 
			System.out.println("Enter a number:");
		}}
		
		while(N<6)
		{
			System.out.println("There should be atleast 6 Players.\r\n" +
					"Enter Number of players:");
			N=input.nextInt();
		}
		
		arr=new Player[N];
		m_no=N/5;				marr=new Mafia[m_no];			//no and array of each type
		d_no=N/5;				darr=new Detective[d_no];
		h_no=Math.max(1,N/10);	harr=new Healer[h_no];
		c_no=N-(m_no+d_no+h_no);	carr=new Commoner[c_no];
		
		for(int i=0;i<m_no;i++)				//initializing all the objects
		{
			Player mm=new Mafia();
			arr[i]=mm;
			marr[i]=(Mafia) mm;
		}
		for(int i=0;i<d_no;i++)
		{
			Player mm=new Detective();
			arr[(m_no+i)]=mm;
			darr[i]=(Detective) mm;
		}	
		for(int i=0;i<h_no;i++)
		{
			Player mm=new Healer();
			arr[(m_no+d_no+i)]=mm;
			harr[i]=(Healer) mm;
		}			
		for(int i=0;i<c_no;i++)
		{
			Commoner mm=new Commoner();
			arr[(m_no+d_no+h_no+i)]=mm;
			carr[i]=mm;
		}
		
		
		System.out.println("Choose a Character\r\n" + 
				"1) Mafia\r\n" + 
				"2) Detective\r\n" + 
				"3) Healer\r\n" + 
				"4) Commoner\r\n" + 
				"5) Assign Randomly");
		
		int q=0; c=0;
		while(c==0)
		{try { input=new Scanner(System.in); q=input.nextInt(); c=1;}
		catch(InputMismatchException ex) { 
			System.out.println("Enter a number:");
		}}
		
		if(q==1)
		{
			System.out.println("You are Player1."); 
			System.out.println("You are a mafia. Other mafias are:");
			for(int i=1;i<m_no;i++)
				System.out.print("[Player"+(i+1)+"],");
			marr[0].run();
		}
		
		else if(q==2)
		{
			System.out.println("You are Player"+(m_no+1)+"."); 
			System.out.println("You are a detective. Other detectives are:");
			for(int i=m_no+1;i<m_no+d_no;i++)
				System.out.print("[Player"+(i+1)+"],");
			darr[0].run();
		}
		
		else if(q==3)
		{
			System.out.println("You are Player"+(m_no+d_no+1)+"."); 
			System.out.println("You are a healer. Other healers are:");
			for(int i=m_no+d_no+1;i<m_no+d_no+h_no;i++)
				System.out.print("[Player"+(i+1)+"],");
			harr[0].run();
		}
		
		else if(q==4)
		{
			System.out.println("You are Player"+(m_no+ d_no+ h_no+1)+"."); 
			System.out.println("You are a commoner. Other commoners are:");
			for(int i=m_no+d_no+h_no+1;i<N;i++)
				System.out.print("[Player"+(i+1)+"],");
			carr[0].run();
		}
		
		else if(q==5)
		{
			int r = rand.nextInt(4);	r++;
			if(r==1)
			{	System.out.println("You are Player1."); 
				System.out.println("You are a mafia. Other mafias are:");
				for(int i=1;i<m_no;i++)
					System.out.print("[Player"+(i+1)+"],");
				marr[0].run();	}
			
			if(r==2)
			{	System.out.println("You are Player"+(m_no+1)+"."); 
				System.out.println("You are a detective. Other detectives are:");
				for(int i=m_no+1;i<m_no+d_no;i++)
					System.out.println("[Player"+(i+1)+"],");
				darr[0].run();	}
			
			if(r==3)
			{	System.out.println("You are Player"+(m_no+d_no+1)+"."); 
				System.out.println("You are a healer. Other healers are:");
				for(int i=m_no+d_no+1;i<m_no+d_no+h_no;i++)
					System.out.print("[Player"+(i+1)+"],");
				harr[0].run();	}
			
			if(r==4)
			{	System.out.println("You are Player"+(m_no+ d_no+ h_no+1)+"."); 
				System.out.println("You are a commoner. Other commoners are:");
				for(int i=m_no+d_no+h_no+1;i<N;i++)
					System.out.print("[Player"+(i+1)+"],");
				carr[0].run();	}
		}
		
	}
	
	public static void output()
	{
		for(int i=1;i<m_no;i++)
			System.out.print("Player"+i+" and ");
		System.out.print("Player"+m_no+" were the Mafias.\n");
		for(int i=1;i<d_no;i++)
			System.out.print("Player"+(m_no+i)+" and ");
		System.out.print("Player"+(m_no+d_no)+" were the Detectives.\n");
		for(int i=1;i<h_no;i++)
			System.out.print("Player"+(m_no+d_no+i)+" and ");
		System.out.print("Player"+(m_no+d_no+h_no)+" were the Healers.\n");
		for(int i=1;i<c_no;i++)
			System.out.print("Player"+(m_no+d_no+h_no+i)+" and ");
		System.out.print("Player"+N+" were the Commoners.\n");
		System.out.println("--End of Sample Case--");
	}
}
