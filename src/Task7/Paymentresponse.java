package Task7;

public class Paymentresponse {
    private String transactionId;
    private String paymentStatus;
    private Double finalAmount;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Paymentresponse(String transactionId, String paymentStatus, Double finalAmount, String message) {
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
        this.finalAmount = finalAmount;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Paymentresponse{" +
                "transactionId='" + transactionId + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", finalAmount=" + finalAmount +
                ", message='" + message + '\'' +
                '}';
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
