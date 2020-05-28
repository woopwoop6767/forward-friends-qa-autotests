package qa.front.friends.logic.pojo;

public class PriceItemTestData extends GeneralItemTestData {


    private String totalCost;
    private String leasingSum;
    private String residualSum;
    private String monthPay;

    public PriceItemTestData(String itemName) {
        super(itemName);
    }
//    public PriceItemTestData(GeneralItemTestData generalItemTestData) {
//        this.generalItemTestData = generalItemTestData;
//    }

    public PriceItemTestData setTotalCost(String totalCost) {
        this.totalCost = totalCost;
        return this;
    }
    public String getTotalCost() {
        return totalCost;
    }

    public PriceItemTestData setLeasingSum(String leasingSum) {
        this.leasingSum = leasingSum;
        return this;
    }
    public String getLeasingSum() { return leasingSum; }

    public PriceItemTestData setResidualSum(String residualSum) {
        this.residualSum = residualSum;
        return this;
    }
    public String getResidualSum() { return residualSum; }

    public PriceItemTestData setMonthPay(String monthPay) {
        this.monthPay = monthPay;
        return this;
    }
    public String getMonthPay() { return monthPay; }


}
