package calculator.views;

import calculator.models.Calculator;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;

public class MainForm extends JFrame {
    private JPanel mainPanel;

    public MainForm(DefaultFormatterFactory formatter) {
        super();
        createUIComponents(formatter);
        configureWindow();
    }

    private void createUIComponents(DefaultFormatterFactory formatter) {

        ResultView resultView = new ResultView(formatter);
        Calculator calculator = resultView.getModel();
        
        OperandView leftOperand = new OperandView(calculator.getLeftOperand(), formatter);
        leftOperand.setObserver(resultView);
        mainPanel.add(leftOperand);
        
        OperatorView operator = new OperatorView(calculator.getOperator());
        operator.setObserver(resultView);
        mainPanel.add(operator);
        
        OperandView rightOperand = new OperandView(calculator.getRightOperand(), formatter);
        rightOperand.setObserver(resultView);
        mainPanel.add(rightOperand);
        
        mainPanel.add(resultView);

        mainPanel.setVisible(true);
    }

    private void configureWindow() {
        setContentPane(mainPanel);
        pack();
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
