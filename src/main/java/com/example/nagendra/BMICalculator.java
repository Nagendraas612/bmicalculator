
package com.example.nagendra;

import java.util.Scanner;
import java.util.Locale;

public class BMICalculator {

    // Calculate BMI
    public static double calculateBMI(double weight, double height) {

        validateInputs(weight, height);

        return weight / (height * height);
    }

    // Validate weight and height
    public static void validateInputs(double weight, double height) {

        if (Double.isNaN(weight) || Double.isInfinite(weight) ||
            Double.isNaN(height) || Double.isInfinite(height)) {

            throw new IllegalArgumentException(
                "Weight and height must be valid numbers"
            );
        }

        if (weight < 1 || weight > 500) {
            throw new IllegalArgumentException(
                "Weight must be between 1 and 500 kg"
            );
        }

        if (height < 0.5 || height > 2.8) {
            throw new IllegalArgumentException(
                "Height must be between 0.5 and 2.8 metres"
            );
        }
    }

    // Determine BMI category
    public static String getCategory(double bmi) {

        if (Double.isNaN(bmi) || Double.isInfinite(bmi) || bmi <= 0) {
            throw new IllegalArgumentException("Invalid BMI value");
        }

        if (bmi < 18.5) {
            return "Underweight";
        }
        else if (bmi < 25) {
            return "Normal";
        }
        else if (bmi < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter weight in kg: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Invalid weight input");
                return;
            }

            double weight = sc.nextDouble();

            System.out.print("Enter height in metres: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Invalid height input");
                return;
            }

            double height = sc.nextDouble();

            double bmi = calculateBMI(weight, height);

            String category = getCategory(bmi);

            System.out.printf(Locale.US, "BMI : %.2f%n", bmi);

            System.out.println("Category : " + category);

        }
        catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }
        finally {
            sc.close();
        }
    }
}
