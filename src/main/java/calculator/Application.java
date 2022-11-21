package calculator;

import calculator.views.MainForm;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;

public class Application {

    private static DefaultFormatterFactory getFactory() {
        DecimalFormat format = new DecimalFormat("0.0#####");
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
        DefaultFormatterFactory factory = new DefaultFormatterFactory();
        factory.setDefaultFormatter(formatter);
        return factory;
    }

    public static void main(String[] args) {
        MainForm form = new MainForm(getFactory());
    }

}
