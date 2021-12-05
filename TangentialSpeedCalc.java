/**
 * TangentialSpeedCalc.java
 * 
 * Calculates the tangential speed of a projectile based on the type of motor
 * the radius of the wheel and the gear ratio used from the motor. Automateically converts the values to the
 * desired units to calculate the speed of the projectile in m/s.
 *
 * @author Jacob Gino
 * @version 1.0
 * @since 11/4/2021
 */

import java.util.*;
public class TangentialSpeedCalc
{
    private Scanner input; // Scanner object to read user input

    public TangentialSpeedCalc()
    {
        input = new Scanner(System.in);
    }

    public static void main(String[] args)
    {
        TangentialSpeedCalc calc = new TangentialSpeedCalc();
        calc.findValues();
        
    }

    /**
     * Finds the values for the tangential speed of the projectile
     */
    public void findValues()
    {
        String motor = new String("");
        double gearRatio = 0.0;
        double speed = 0.0;
        double radius = 0.0;

        System.out.print("Enter the motor type(775pro or Falcon):  ");
        motor = input.nextLine();
        System.out.print("Enter the gear ratio: ");
        gearRatio = input.nextDouble();
        System.out.print("Enter the radius of the wheel in inches:  ");
        radius = input.nextDouble();

        if(motor.trim().equalsIgnoreCase("775pro"))
        {
            speed = 18730.0;
        }
        else if(motor.trim().equalsIgnoreCase("Falcon"))
        {
            speed = 6380.0;
        }
        else
        {
            System.out.println("Invalid motor type. Please try again.");
            motor = input.nextLine();
        }

        calculateSpeed(gearRatio,speed,radius);
    }

    /**
     * Calculates the tangential speed of the projectile
     * @param gr The gear ratio of the motor
     * @param s the speed of the motor given by the user
     * @param r the radius of the wheel in inches
     */
    public void calculateSpeed(double gr,double s, double r)
    {
        double gearRatio = gr;
        double speed = s;
        double radius = r;
        speed /= gearRatio;
        speed *= 0.10472;
        radius = radius * 0.0254;
        speed *= radius;

        System.out.printf("\nThe tangential speed is: %.3f\n\n",speed);

    }
    
}