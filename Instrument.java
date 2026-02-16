public class Instrument {

    protected String manufacturer;
    protected int price;

    public Instrument(String manufacturer, int price) {
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getDetails() {
        return "Valmistaja: " + manufacturer + ", Hinta: " + price + "e";
    }
}
