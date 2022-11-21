package calculator.views;

import calculator.models.Operator;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;


public class OperatorView extends JPanel implements Observable {
    
    private final Operator model;
    private final List<OperatorButton> buttons;
    
    public OperatorView(Operator model) {
        super();
        this.model = model;
        this.setLayout(new GridLayout(Operator.allowedOperators.length, 1));
        List<OperatorButton> buttons = createButtonGroup();
        buttons.forEach(this::add);
        buttons.get(0).setSelected(true);
        this.buttons = buttons;
        this.setVisible(true);
    }

    private List<OperatorButton> createButtonGroup() {
        ButtonGroup group = new ButtonGroup();
        return Arrays.stream(Operator.allowedOperators)
            .map(str -> new OperatorButton(str, group))
            .toList();
    }

    private void setChangeListener(OperatorButton button, Observer observer) {
        button.addChangeListener(e -> {
            if (button.isSelected()) {
                model.setValue(button.getOperator());
                observer.update();
            }
        });
    }

    public Operator getModel() {
        return model;
    }

    @Override
    public void setObserver(Observer observer) {
        for (var button: buttons) {
            setChangeListener(button, observer);
        }
    }

    private static class OperatorButton extends JRadioButton {

        private final String operator;

        public OperatorButton(String operator, ButtonGroup group) {
            super();
            group.add(this);
            this.operator = operator;
            setText(operator);
            setVisible(true);
        }

        public String getOperator() {
            return this.operator;
        }

    }

}
