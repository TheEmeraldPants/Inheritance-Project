public class Case extends Component {
    private String style;
    private String dimensions;
    private String ports;

    public Case(double price, String brand, boolean hasRGB, int powerConsumption, String description, String style, String dimensions, String ports) {
        super(price, brand, hasRGB, powerConsumption, description);
        this.style = style;
        this.dimensions = dimensions;
        this.ports = ports;
    }

    public String getStyle() {
        return style;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String getPorts() {
        return ports;
    }
}
