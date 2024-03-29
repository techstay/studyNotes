package tech.techstay.strategy;

public class StrategySample {
  public static void main(String[] args) {
    Strategy fast = new FastStrategy();
    Strategy slow = new SlowStrategy();
    Calculator calculator = new Calculator();
    calculator.setStrategy(fast);
    System.out.println("fast result:" + calculator.calc(3, 4));

    calculator.setStrategy(slow);
    System.out.println("slow result:" + calculator.calc(3, 4));
  }
}
