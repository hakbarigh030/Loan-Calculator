/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hamid Akbari Ghannad
 */
public final class Loan {
    private double principal;
    private int duration;
    private double annualInterestRate;
    
    public Loan(double principal, int duration, double annualInterestRate) {
        this.principal = principal;
        this.duration = duration;
        this.annualInterestRate = annualInterestRate;
    }
    
    public double getPrincipal() {
        return principal;
    }
    public void setPrincipal(double principal) {
        this.principal = Math.max(principal, 0);
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = Math.max(duration, 1);
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = Math.max(annualInterestRate, 0);
    }

    public double getMonthlyInterestRate() {
        return this.getAnnualInterestRate()/12;
    }
    
    public double getMonthlyPayment() {
        double P = this.getPrincipal();
        double J = this.getMonthlyInterestRate()/100;
        int n = this.getDuration();
        double M = P*J/(1-Math.pow(1+J, -n));
        
        return M;
    }
    
    public double getTotalPayment() {
        double M = this.getMonthlyPayment();
        int n = this.getDuration();
        
        return n*M;
    }
    
    public double getTotalInterest() {
        return this.getTotalPayment()-this.getPrincipal();
    }
    
    public double getMonthlyInterest() {
        return this.getTotalPayment()/this.getDuration();
    }
    
    public double getAnnualInterest() {
        return 12*this.getMonthlyInterest();
    }
}
