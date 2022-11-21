package calculator.views;

import calculator.models.Operand;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class OperandView extends ComplexNumberView implements Observable {
    
    private final Operand model;
    
    public OperandView(Operand model, DefaultFormatterFactory formatterFactory) {
        super(formatterFactory);
        this.model = model;
        realField.setValue(model.getReal());
        imagField.setValue(model.getImag());
    }
    
    private double extractDoubleValue(JTextField field) {
        String stringRepresentation = field.getText().replace(',', '.');
        try {
            return Double.parseDouble(stringRepresentation);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    @Override
    public void setObserver(Observer observer) {
        realField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                double value = extractDoubleValue(realField);
                model.setReal(value);
                observer.update();
            }
        });
        imagField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                double value = extractDoubleValue(imagField);
                model.setImag(value);
                observer.update();
            }
        });
    }

}
