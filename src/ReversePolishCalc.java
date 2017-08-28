
public class ReversePolishCalc {

  private int top = 0;
  private String[] stack;

  public double calculate(String input) {
    String[] tokens = input.split( "," );
    stack = new String[tokens.length];

    for(int i = 0; i < tokens.length; i++) {
      String token = tokens[i];
      if ("+".equals(token)) {
        push(pop() + pop());
      } else if ("-".equals(token)) {
        double op2 = pop();
        double op1 = pop();
        push(op1 - op2);
      } else if ("*".equals(token)) {
        push(pop() * pop());
      } else if ("/".equals(token)) {
        double op2 = pop();
        double op1 = pop();
        push(op1 /   op2);
      } else {
        push(token);
      }
    }
    return pop();
  }

  private void push(String number) {
    int b;
    b = top;
    stack[b] = number;
    top++;
  }

  private void push(double d) {
    int a;
    a = top;
    stack[a] = Double.toString(d);
    top++;
  }

  private double pop() {
    int i;
    --top;
    i = top;
    return Double.parseDouble(stack[i]);
  }
}
