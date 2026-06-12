package Task7;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Paymentgateway {
    public static void main(String args[]) {
        @FunctionalInterface
        interface PaymentGateway {
            Paymentresponse pay(Paymentrequest request);
        }

        Paymentrequest request = new Paymentrequest(
                "P101",
                "Ravi",
                25000.0,
                "UPI",
                "COURSE10",
                null,
                null
        );

        Predicate<Paymentrequest> validateAmount = req -> req.getAmount() > 0;

        Function<Paymentrequest, Paymentrequest> applycoupon = req -> {
            if (req.getCouponCode().equals("COURSE10")) {
                req.setAmount(req.getAmount() * 0.9);
            }
            return req;
        };

        Supplier<String> txnGenerator = () -> "TXN" + System.currentTimeMillis();

        PaymentGateway upiGateway = req -> {

            String txnId = txnGenerator.get();

            return new Paymentresponse(
                    txnId,
                    "SUCCESS",
                    req.getAmount(),
                    "UPI Payment Successful"
            );
        };

        if (!validateAmount.test(request)) {
            System.out.println("Invalid Amount");
            return;
        }


        request = applycoupon.apply(request);


        Paymentresponse response =
                upiGateway.pay(request);


        System.out.println("Payment Mode: " + request.getPaymentMode());

        System.out.println("Final Amount: " + response.getFinalAmount());

        System.out.println("Transaction ID: " + response.getTransactionId());

        System.out.println("Payment Status: " + response.getPaymentStatus());


    }
}

