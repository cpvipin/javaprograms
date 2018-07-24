/**
Grid Search Hacker rank problem.
https://www.hackerrank.com/challenges/the-grid-search/problem

Given a 2D array of digits or grid, try to find the occurrence of a given 2D pattern of digits. For example, consider the following grid:
1234567890  
0987654321  
1111111111  
1111111111  
2222222222  
Assume we need to look for the following 2D pattern array:
876543  
111111  
111111
The 2D pattern begins at the second row and the third column of the grid. The pattern is said to be present in the grid.

Thus return YES.

For more test cases follow hacker rank link.
*/
import java.io.*;
import java.util.*;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
    	
    	for(int i=0;i<G.length;i++)
    	{
    		
    		for(int j=0;j<=(G[0].length()-P[0].length());j++)
    		{
    			String subG=G[i].substring(j,j+P[0].length());
    			
    			if(subG.equals(P[0]))
    			{
    				if(walkAll(i+1,j,G,P))
    				{
    					return "YES";
    				}
    				
    			}
    		}
    		
    	}

return "NO";
    }
    
    
    static boolean walkAll(int i,int j , String[] G,String[] P)
    {
    	int k=1;
    	while((G[i].substring(j, j+P[0].length())).equals(P[k]))
    	{
    		k++;
    		i++;
    		
    		
    		if(k==(P.length))
    		{
    			return true;
    		}
    		if(i>=G.length)
    		{
    			
    			break;
    		}
    	}
    	
    	return false;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);
            System.out.println("result:"+result);
           /* bufferedWriter.write(result);
            bufferedWriter.newLine();*/
        }

      //  bufferedWriter.close();

        scanner.close();
    }
}
