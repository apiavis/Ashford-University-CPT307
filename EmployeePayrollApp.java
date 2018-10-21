/*
 * Title: Employee Payroll App
 * Author: Alicia Piavis
 * Course: CPT 307 Data Structures, Algorithms, & Design
 * Instructor: Dr. Brenda Holland
 * Date: 10/20/2018
 */

/* This program calculates payroll information 
 * including gross pay, tax deductions, and 
 * net pay, all from input including
 * employee name, pay rate, and hours worked.
 */

//imports necessary Java libraries
import java.io.*;
import java.text.DecimalFormat;

public class EmployeePayrollApp
{
    //constant variables are declared and assigned
    public static final double MEDICARE = 0.0145;
    public static final double STATE_TAX = 0.0307;
    public static final double FEDERAL_TAX = 0.15;
    public static final double SOCIAL_SECURITY = 0.062;
    public static final double UNEMPLOYMENT_INSURANCE = 0.0007;

    public static void main(String[] args)
    {
        //other variables are declared and assigned (some are set to zero initially)
        String employeeName = null, mustBeNumeric = "[-+]?\\d+(\\.\\d+)?";
        char inputAskRepeat = 0;
        double employeePayRate = 0, hoursWorked = 0, overtimeWorked = 0, grossPay = 0;
        double deductionFedTax = 0, deductionStateTax = 0, deductionMedicare = 0;
        double deductionSocialSecurity = 0, deductionUnemployment = 0, totalDeductions = 0, netPay = 0;
        boolean boolRepeat = true;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //prints prompt for beginning of application
        System.out.println("---------------------------");
        System.out.println("Employee Payroll Calculator");
        System.out.println("---------------------------");
        
        //beginning of "while" loop that allows the application to run continuously
        while (boolRepeat == true)
        {
            boolean boolAskRepeat = true;

            //requests input for employee name
            System.out.print("Please enter the employee name: ");

            //ensures that employee name entered is valid
            try {employeeName = input.readLine(); } 
            catch (IOException e) {}

            //declares and assigns variables for the following "while" loop
            String stringCheckPayRate = null;
            boolean boolCheckPayRate = true;
            while (boolCheckPayRate == true)
            {
                //requests inpput for employee pay rate
                System.out.print("Please enter employee pay rate (earned per hour): $ ");
                //checks that input is valid
                try { stringCheckPayRate = input.readLine(); } 
                catch (IOException e) {}
                //checks conditions to determine future of the loop
                if (stringCheckPayRate.matches(mustBeNumeric))
                {
                    boolCheckPayRate= false;
                    employeePayRate = Double.parseDouble(stringCheckPayRate);
                }
                else 
                    boolCheckPayRate = true;
            }

            //declares and assigns variables for the following "while" loop
            String stringCheckHours = null;
            boolean boolCheckHours = true;
            while (boolCheckHours == true)
            {
                //requests input for number of hours worked
                System.out.print("Please enter employee hours worked: ");
                //checks that input is valid
                try { stringCheckHours = input.readLine(); } 
                catch (IOException e) {}
                //checks conditions to determine future of the loop
                if (stringCheckHours.matches(mustBeNumeric))
                {
                    boolCheckHours = false;
                    hoursWorked = Double.parseDouble(stringCheckHours);
                }
                else 
                    boolCheckHours = true;
            }
            
            //checks conditions to determine how overtime and gross pay will be calculated
            if (hoursWorked <= 40)
            {    
                grossPay = hoursWorked * employeePayRate;
                overtimeWorked = 0;
            }    
            else 
            {    
                grossPay = ((hoursWorked - 40) * (employeePayRate * 1.5)) + (40 * employeePayRate);
                overtimeWorked = hoursWorked - 40;
            }
            
            //calculates tax deductions, total deductions, and netpay
            deductionFedTax = grossPay * FEDERAL_TAX;
            deductionStateTax = grossPay * STATE_TAX;
            deductionMedicare = grossPay * MEDICARE;
            deductionSocialSecurity = grossPay * SOCIAL_SECURITY;
            deductionUnemployment = grossPay * UNEMPLOYMENT_INSURANCE;
            totalDeductions = deductionFedTax + deductionStateTax + deductionMedicare + deductionSocialSecurity + deductionUnemployment;
            //truncates value of variable to two decimal places
            totalDeductions = Double.parseDouble(new DecimalFormat("##.##").format(totalDeductions));
            netPay = grossPay - totalDeductions;
            //trauncates value of variable to two decimal places
            netPay = Double.parseDouble(new DecimalFormat("##.##").format(netPay));
            
            //prints payroll information output
            System.out.println("-------------------------------------------------------");
            System.out.println("Employee Name: " + employeeName);
            System.out.println("Employee Pay Rate: $ " + employeePayRate);
            System.out.println("Hours Worked: " + hoursWorked);
            System.out.println("Overtime Worked: " + overtimeWorked);
            System.out.println("Gross Pay: $ " + grossPay);
            System.out.println("Total Deductions: $ " + totalDeductions);
            System.out.println("Net Pay: $ " + netPay);
            
            //loop which directs larger "while" loop as to whether or not program will run again
            while (boolAskRepeat == true)
            {
                System.out.println("-------------------------------------------------------");
                //asks user if they want to run the program again
                System.out.print("Another payroll calculation? (Y or N): ");

                //checks for valid input
                try { inputAskRepeat = input.readLine().toLowerCase().charAt(0); } 
                catch (IOException e) {}

                //branch which causes loop to continue or exit
                if (inputAskRepeat == "n".charAt(0))
                {
                    boolAskRepeat = false;
                    boolRepeat = false;
                }
                else if (inputAskRepeat == "y".charAt(0))
                {
                    boolAskRepeat = false;
                    boolRepeat = true;
                System.out.println("-------------------------------------------------------");                    
                }
                else boolAskRepeat = true;
                System.out.println("-------------------------------------------------------");                
            }
        }
        
        //end of the program if user doe not want another payroll calculation
        System.out.print("\nProgram terminated...");
    }
}
   