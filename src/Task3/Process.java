package Task3;

import java.util.Arrays;

@FunctionalInterface
interface  OrderProcessor{
    Order process(Order order);

    default OrderProcessor andThen(OrderProcessor nextProcessor) {
        return order -> nextProcessor.process(this.process(order));
    }
}

public class Process{
  public static void main(String args[]){

      Order order=new Order("ORD101","shiva", Arrays.asList("book","pen","pencil"),"completed",500.0,"delivered","GENAI10");
      OrderProcessor validateOrder = o -> {
          System.out.println("Order Validated");
          return o;
      };

      OrderProcessor applyCoupon = o -> {
          o.setTotalAmount(o.getTotalAmount() * 0.9);
          System.out.println("Coupon Applied");
          return o;
      };

      OrderProcessor calculateGst = o -> {
          o.setTotalAmount(o.getTotalAmount() * 1.18);
          System.out.println("GST Added");
          return o;
      };

      OrderProcessor confirmPayment = o -> {
          o.setPaymentStatus("SUCCESS");
          System.out.println("Payment Confirmed");
          return o;
      };

      OrderProcessor assignDelivery = o -> {
          o.setDeliveryStatus("ASSIGNED");
          System.out.println("Delivery Assigned");
          return o;
      };

      Order finalOrder =
              validateOrder
                      .andThen(applyCoupon)
                      .andThen(calculateGst)
                      .andThen(confirmPayment)
                      .andThen(assignDelivery)
                      .process(order);

      System.out.println(finalOrder);
  }
}




