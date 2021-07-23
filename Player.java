package sem3;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

abstract class Player {
	HPclass HP;
	
	public Player()
	{
		HP=new HPclass();
	}
	
	public abstract void run();
	
	public void reduceHP(Player target,int n)
	{
		int sum=0;
		for(int i=0;i<Game_Mafia.m_no;i++)
			if(Game_Mafia.arr[i]!=null)
				sum+=Game_Mafia.arr[i].HP.HP;		//calculate total HPs of Mafias
		
		if(sum>target.HP.HP)
		{
			target.HP.HP=0;
			for(int i=0;i<Game_Mafia.m_no;i++)
			{
			  if(Game_Mafia.arr[i]!=null)
			  {  if(Game_Mafia.arr[i].HP.compareTo(target.HP)>=0 && Game_Mafia.arr[i].HP.HP>=(target.HP.HP/n))
					Game_Mafia.arr[i].HP.HP-=(target.HP.HP/n);
				 else
					Game_Mafia.arr[i].HP.HP=0; }
			}
		}
		else
		{
			target.HP.HP-=sum;
			for(int i=0;i<Game_Mafia.m_no;i++)			
				Game_Mafia.arr[i].HP.HP=0;
		}
	}
}
