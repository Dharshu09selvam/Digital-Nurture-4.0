public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp("MobileApp v1.0");
        Observer web = new WebApp("WebApp 2.1");

        stockMarket.register(mobile);
        stockMarket.register(web);

        stockMarket.setPrice(1015.75);
        stockMarket.setPrice(1032.40);

        stockMarket.deregister(web);
        stockMarket.setPrice(1050.00);
    }
}
