package Compoenents;
public class Case extends Component {
    private String style;
    private String dimensions;
    private String[] ports;

    public Case(double price, String brand, boolean hasRGB, int powerConsumption, String description, String style, String dimensions, String[] ports) {
        super(price, brand, hasRGB, powerConsumption, description);
        this.style = style;
        this.dimensions = dimensions;
        this.ports = ports;
        description= "A case is a box that contains and protects the main components of a computer, including the motherboard, central processing unit (CPU), power supply unit (PSU), and storage devices. Cases are available in a variety of sizes and styles to accommodate different types of hardware and personal preferences.";
    }

    public String getStyle() {
        return style;
    }

    public String getDimensions() {
        return dimensions;
    }

    public String[] getPorts() {
        return ports;
    }

    public String[] setPorts(String[] ports) {
        this.ports = ports;
    }
}
