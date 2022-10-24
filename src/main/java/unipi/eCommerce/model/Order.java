package unipi.eCommerce.model;

public class Order {
    public enum OrderStatus {PENDING, SHIPPED, DELIVERED};

    private Customer customer;
    private String orderNumber;
    private long orderDate;
    private String shippingAddress;
    private long shippingDate;
    private String shippingCountry;
    private String paymentType;
    private String paymentNumber;
    private OrderStatus status;
    private double total;

    public Order(Customer customer, String orderNumber, long orderDate, String shippingAddress, long shippingDate, String shippingCountry, String paymentType, String paymentNumber, OrderStatus status, double total) {
        this.customer = customer;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.shippingDate = shippingDate;
        this.shippingCountry = shippingCountry;
        this.paymentType = paymentType;
        this.paymentNumber = paymentNumber;
        this.status = status;
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public long getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(long shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
