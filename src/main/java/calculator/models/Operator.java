package calculator.models;

public class Operator  {

    public static final String[] allowedOperators = {"+", "-", "*", "/"};
    private String value;
    
    public Operator() {
        this.value = allowedOperators[0];
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
