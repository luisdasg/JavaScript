package javaapplication5;

public class TravelCost {
    private double MtoDrive;
    private double MperG;
    private double ParkingCost;
    private double TollCost;
    private double TotalCost;
    private double GasPrice;
    public TravelCost(double mtd, double mpg, double tc, double pc, double gp)
    {
        this.MperG=mpg;
        this.MtoDrive=mtd;
        this.ParkingCost=pc;
        this.TollCost=tc;
        this.GasPrice=gp;
    }
    public void CalCost()
    {
        this.TotalCost=((this.MtoDrive/this.MperG)*this.GasPrice)+this.ParkingCost+this.TollCost;
    }
    public double getTotalCost()
    {
        return this.TotalCost;
    }
}
