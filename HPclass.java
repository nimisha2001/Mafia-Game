package sem3;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class HPclass implements Comparable<HPclass> {
	int HP;
	
	@Override
	public int compareTo(HPclass h)
	{
		return this.HP-h.HP;
	}	
}
