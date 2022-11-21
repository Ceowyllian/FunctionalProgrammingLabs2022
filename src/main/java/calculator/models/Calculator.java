package calculator.models;


public class Calculator {
    private final Operand leftOperand = new Operand();
    private final Operand rightOperand = new Operand();
    private final Operator operator = new Operator();
    
    public Complex computeValue() {
        Complex left = leftOperand.getValue();
        Complex right = rightOperand.getValue();
        String operator = this.operator.getValue();
        return switch (operator) {
            case "+" -> left.$plus(right);
            case "-" -> left.$minus(right);
            case "*" -> left.$times(right);
            case "/" -> left.$div(right);
            default -> throw new IllegalArgumentException();
        };
    }

    public Operand getLeftOperand() {
        return this.leftOperand;
    }

    public Operand getRightOperand() {
        return rightOperand;
    }
    
    public Operator getOperator() {
        return operator;
    }
    
}
