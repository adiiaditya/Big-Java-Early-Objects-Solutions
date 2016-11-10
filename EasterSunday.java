import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EasterSunday{
    public static void main (String[] args){
        int year;
        System.out.println("Enter the year EasterSunday is required for: ");
        BufferedReader br = null;
        
        try {
            br = new BufferedReader (new InputStreamReader(System.in));
            year = Integer.parseInt(br.readLine());
            calculateEasterSunday(year);
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
    public static void calculateEasterSunday(int year){
        int a,b,c,d,e,g,h,j,k,m,r,n,p;
        a = year%19;
        c = year%100;
        b = year/100;
        e = b%4;
        d = b/4;
        g = (8*b+13)/25;
        h = (19*a+b-d-g+15)%30;
        j = c/4;
        k = c%4;
        m = (a+11*h)/319;
        r = (2*e+2*j-k-h+m+32)%7;
        n = (h-m+r+90)/25;
        p = (h-m+r+n+19)%32;
        String month = findMonth(n);
        System.out.println("The EasterSunday for year "+ year + " is " + month + " " + p);
    }
    public static String findMonth(int n){
        switch(n){
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default: return "The month is wrong";
        }
    }
}