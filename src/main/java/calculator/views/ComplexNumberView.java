package calculator.views;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;


public abstract class ComplexNumberView extends JPanel {

    protected final JFormattedTextField realField;
    protected final JFormattedTextField imagField;

    public ComplexNumberView(DefaultFormatterFactory formatterFactory) {
        super();
        
        setLayout(new GridLayout(2, 2));
        realField = createField("Real", formatterFactory);
        imagField = createField("Imag", formatterFactory);
        this.setVisible(true);
    }
    

    private JFormattedTextField createField(String label, DefaultFormatterFactory factory) {
        JLabel jLabel = new JLabel(label);
        this.add(jLabel);
        JFormattedTextField field = new JFormattedTextField(factory);
        field.setValue(0);
        field.setPreferredSize(new Dimension(80, 13));
        this.add(field);
        return field;
    }

}
