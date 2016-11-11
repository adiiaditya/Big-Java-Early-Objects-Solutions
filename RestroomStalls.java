import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class RestroomStalls{
    public static void main(String[] args){
        
        BufferedReader br = null;
        
        try {
            br = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Enter the number of stalls: ");
            int stalls= Integer.parseInt(br.readLine());
            boolean[] arr_stalls=new boolean[stalls];
            for(int i = 0; i < stalls; i++){
                System.out.println();
                arr_stalls[generateSequence(arr_stalls)] = true;
                
                for (int j = 0; j < stalls; j++) {
                    if (arr_stalls[j]) System.out.print("X ");
                    else System.out.print("_ ");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static int generateSequence(boolean[] arr_stalls){
        int init = -1;
        int maxLength = 0;
        int currentStart = -1;
        int currentRun = 0;
        boolean isRun = false;
        
        for (int i = 0; i < arr_stalls.length; i++) {
            if (isRun && arr_stalls[i]) {
                isRun = false;
                
                if (currentRun >= maxLength) {
                    maxLength = currentRun;
                    init = currentStart;
                }
            } else if (!isRun && !arr_stalls[i]) {
                isRun = true;
                currentStart = i;
                currentRun = 1;
            } else if (isRun && !arr_stalls[i]) { 
                currentRun++;
            }
        }
        
        if (isRun) {
            if (currentRun >= maxLength) {
                maxLength = currentRun;
                init = currentStart;
            }
        }
        
        int mid = (maxLength - 1) / 2 + init;
        return mid;
    }
}