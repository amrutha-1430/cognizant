import java.util.HashMap;
import java.util.Map;

public class Main {

    // 1. BASIC RECURSION: Time Complexity is O(N)
    // Formula: Future Value = Past Value * (1 + Growth Rate)
    public static double forecastFutureValue(double pastValue, double growthRate, int years) {
        // Base Case: If no years remain, return the baseline past value
        if (years <= 0) {
            return pastValue;
        }
        
        // Recursive Case: Calculate the value for (years - 1) and apply current growth
        return (1 + growthRate) * forecastFutureValue(pastValue, growthRate, years - 1);
    }

    // 2. OPTIMIZED RECURSION (Memoization): O(N) time but avoids recalculations
    // Essential for multi-variable or branching recursive structures (like Fibonacci-based forecasting models)
    private static Map<Integer, Double> memo = new HashMap<>();

    public static double optimizedForecast(double pastValue, double growthRate, int years) {
        if (years <= 0) return pastValue;
        
        // Check if we have already calculated this year's value before
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        
        // Compute and store the result in cache memory before returning
        double result = (1 + growthRate) * optimizedForecast(pastValue, growthRate, years - 1);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0; // $10,000 starting cash
        double annualGrowth = 0.07;         // 7% constant annual growth rate
        int forecastPeriod = 10;            // Forecast out for 10 years

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.printf("Initial Value: $%.2f | Growth Rate: %.1f%%\n\n", initialInvestment, (annualGrowth * 100));

        // Testing standard recursion
        double futureValue = forecastFutureValue(initialInvestment, annualGrowth, forecastPeriod);
        System.out.printf("Predicted Value after %d years (Standard): $%.2f\n", forecastPeriod, futureValue);

        // Testing optimized memoized recursion
        double optimizedValue = optimizedForecast(initialInvestment, annualGrowth, forecastPeriod);
        System.out.printf("Predicted Value after %d years (Optimized): $%.2f\n", forecastPeriod, optimizedValue);
    }
}
