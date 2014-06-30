import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


class SquareQuestion
{	static char[] stringArray;
	static boolean bool= false;
	
	public static String longestRepeatedSubstring(String string){
		String result;
		stringArray = string.toCharArray();
		int stringLength = stringArray.length;
    	int[][] logicMatrix = new int[stringLength + 1][stringLength + 1];
    	for (int i = 0; i <= stringLength; ++i) {
        	logicMatrix[i][0] = 0;
        	logicMatrix[0][i] = 0;
    	}
	
    	int lengthOfSubstring = 0, initialPointer = stringLength+1;
    	for (int i = 1; i <= stringLength; ++i) {
        	for (int j = 1; j <= stringLength; ++j) {
        		if(j>=2 && eval(j)){
            	if (stringArray[i-1] == stringArray[j-1]  && Math.abs(j-i) > logicMatrix[i-1][j-1] ){
            		logicMatrix[i][j] = logicMatrix[i-1][j-1]+1;
                	if (logicMatrix[i][j] > lengthOfSubstring) {
                    	lengthOfSubstring = logicMatrix[i][j];
                    	initialPointer = Math.min(i, j);
                	}
            		}else {
                		logicMatrix[i][j] = 0;
            			}}
            			else{
            				
            				if (j==1 && stringArray[i-1] == stringArray[j-1]  && Math.abs(j-i) > logicMatrix[i-1][j-1]){
            		logicMatrix[i][j] = logicMatrix[i-1][j-1]+1;
                	if (logicMatrix[i][j] > lengthOfSubstring) {
                    	lengthOfSubstring = logicMatrix[i][j];
                    	initialPointer = Math.min(i, j);
                	}
            		}else {
                		logicMatrix[i][j] = 0;
            			}
            				
            			}
        	}
    	}
    
    	int indx1 = initialPointer - lengthOfSubstring;
    	int indx2 = initialPointer;    // inxd2 = initialPointer - lengthOfSubstring + lengthOfSubstring;
    	return result = (lengthOfSubstring>0) ? ((!string.substring(indx1,indx2).trim().isEmpty()) ? string.substring(indx1,indx2) : "NONE") : "NONE";
    
	}
	
	public static boolean eval(int j){
		if(stringArray[j-1]!=stringArray[j-2])
		 bool = true;
		
		return bool;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
	//	String string = "am so uniqe";
		if(args.length > 0) {
            File file = new File(args[0]);
            FileInputStream fis = null;
            BufferedReader reader = null;
            try {
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));
            String string = reader.readLine();
            while(string != null){
                String subString = longestRepeatedSubstring(string);
				System.out.println(subString);
                string = reader.readLine();
            }           
          
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
          
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
	}
}

}

