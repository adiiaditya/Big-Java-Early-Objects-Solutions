import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TaxCalculator{
    static double taxPayable;
    public static void main(String[] args){
        
        BufferedReader br = null;
        
        try {
            br = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Please enter your income: ");
            double income = Double.parseDouble(br.readLine());
            System.out.println("Enter your marital status(Single/Married): ");
            String maritalStatus = br.readLine();
            computeTax(income,maritalStatus);
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
    
    public static void computeTax(double income, String status)
    {
        taxPayable = 0.0;
        if(status.equals("Single"))
        {
            if(income > 0 && income <= 8000)
            {
                taxPayable = (0.1 * income);
            }
            else if(income > 8000 && income <= 32000)
            {
                taxPayable= 0.15 * (income-8000) +800;
            }
            else if(income>32000)
            {
                taxPayable= 0.25 * (income-32000) +4400;
            }
        }
        else if(status=="Married")
        {
            if(income>0 && income<= 16000)
            {
                taxPayable=(0.1 * income);
            }
            else if(income>16000 && income <= 64000)
            {
                taxPayable= 0.15 *(income-16000) + 1600;
            }
            else if(income>64000)
            {
                taxPayable= 0.25 * (income-64000) + 8800;
            }
        }
        System.out.println("Tax to be paid is: " + taxPayable);
    }
}
