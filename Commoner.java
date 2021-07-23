package sem3;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Commoner extends Player {

	public Commoner() {
		super();
		this.HP.HP=1000;
	}
	
	public void run()
	{ Scanner input=new Scanner(System.in);
	  Random rand = new Random();
		
		int round=1;
		int n=Game_Mafia.N;		//current no of players
		int no_of_m=n/5;		//total no of mafias
		int no_of_d=n/5;		//total no of detectives
		int no_of_h=Game_Mafia.h_no;		//total no of healers
		
		while(no_of_m>0 && ((n-no_of_m)>no_of_m))
		{
			System.out.println("\n\nRound "+round+":\r\n" + n+" players are remaining:"); 
			for(int i=0;i<Game_Mafia.N;i++)
				if(Game_Mafia.arr[i]!=null)
					System.out.print("Player"+(i+1)+", ");
			System.out.println();
			
			System.out.println("Mafias have chosen their target.");
			int t=rand.nextInt(Game_Mafia.N);	t++;
			while((t>0 && t<=Game_Mafia.m_no) || Game_Mafia.arr[t-1]==null)
				{t=rand.nextInt(Game_Mafia.N); t++;}
			reduceHP(Game_Mafia.arr[t-1],no_of_m);
			
			System.out.println("Detectives have chosen a player to test.");
			int d= rand.nextInt(Game_Mafia.N);	d++;
			while((d>Game_Mafia.m_no && d<=(Game_Mafia.m_no+Game_Mafia.d_no)) || Game_Mafia.arr[d-1]==null)
				{ d=rand.nextInt(Game_Mafia.N);	d++; }

			
			System.out.println("Healers have chosen someone to heal.");
			int h= rand.nextInt(Game_Mafia.N);	h++;
			while((h>(Game_Mafia.m_no+Game_Mafia.d_no) && h<=(Game_Mafia.N-Game_Mafia.c_no)) || Game_Mafia.arr[h-1]==null)
				{ h=rand.nextInt(Game_Mafia.N);	h++; }
			
			System.out.println("--End of actions--\r\n");			
			
			
			if(no_of_h>0 && h==t)												//if mafia and healer choose same person
				Game_Mafia.arr[t-1].HP.HP+=500;
			
			else
			{
				if(Game_Mafia.arr[t-1].HP.HP<=0)
				{ System.out.println("Player"+t+" has died.");			//that person dies
				  Game_Mafia.arr[t-1]=null;	n--; 
				  if(t>Game_Mafia.m_no && t<=(Game_Mafia.m_no+Game_Mafia.d_no))		//if died is detective
						no_of_d--;
				  if(t>(Game_Mafia.m_no+Game_Mafia.d_no) && t<=(Game_Mafia.m_no+Game_Mafia.d_no+Game_Mafia.h_no)) //if died is healer
						no_of_h--;}
				
			  if(no_of_h>0)
				  Game_Mafia.arr[h-1].HP.HP+=500;									//hp+=500
			
			}
			
			if((n-no_of_m)<=no_of_m)						//if winning condition fulfilled
				break;
						
			if(no_of_d>0 && d>0 && d<=Game_Mafia.m_no)				//if detective chose mafia
			{
				System.out.println("Player"+d+" has died.");
				Game_Mafia.arr[d-1]=null;	n--;
				no_of_m--;
			}
			
			else
			{
				if(Game_Mafia.arr[(Game_Mafia.m_no+Game_Mafia.d_no+Game_Mafia.h_no)]!=null)				//If i am alive
				{System.out.println("Select a person to vote out:");
				int c=0; while(c==0)
				{try { input=new Scanner(System.in); int v=input.nextInt(); c=1;}
				catch(InputMismatchException ex) { 
					System.out.println("Enter a number:");
				} }
				}
				
				int r=rand.nextInt(Game_Mafia.N);		//voted out player
				while(Game_Mafia.arr[r]==null)
					r=rand.nextInt(Game_Mafia.N);
	
				System.out.println("Player"+(r+1)+" has been voted out.");
				Game_Mafia.arr[r]=null;	n--;
				if(r>=0 && r<Game_Mafia.m_no)
					no_of_m--;
				else if(r>=Game_Mafia.m_no && r<(Game_Mafia.m_no+Game_Mafia.d_no))
					no_of_d--;
				else if(r>=(Game_Mafia.m_no+Game_Mafia.d_no) && r<(Game_Mafia.m_no+Game_Mafia.d_no+Game_Mafia.h_no))
					no_of_h--;
			}
			
			System.out.println("--End of Round "+round+"--\r\n");
			round++;
			
	//System.out.println("no of mafias "+no_of_m);
		}
		
		System.out.println("\nGame Over.");
		if(no_of_m==0)
			System.out.println("The Mafias have lost.");
		else
			System.out.println("The Mafias have won.");
		
		Game_Mafia.output();
	}
	
}
