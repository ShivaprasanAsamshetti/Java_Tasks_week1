package Task10;

public class Payment {
    private Integer paymentId;
    private Integer studentId;
    private Double amount;
    private String status;

    public Payment(Integer paymentId, Integer studentId, Double amount, String status) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.amount = amount;
        this.status = status;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", studentId=" + studentId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }
}
