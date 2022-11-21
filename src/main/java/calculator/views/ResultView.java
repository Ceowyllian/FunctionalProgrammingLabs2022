package calculator.views;

import calculator.models.Calculator;
import calculator.models.Complex;

import javax.swing.text.DefaultFormatterFactory;


public class ResultView extends ComplexNumberView implements Observer {
    
    private final Calculator model = new Calculator();
    
    public ResultView(DefaultFormatterFactory formatterFactory) {
        super(formatterFactory);
        realField.setEditable(false);
        imagField.setEditable(false);
    }

    public Calculator getModel() {
        return model;
    }

    @Override
    public void update() {
        Complex value = model.computeValue();
        realField.setValue(value.real());
        imagField.setValue(value.imag());
    }
}
