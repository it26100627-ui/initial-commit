import java.util.Scanner;

    class StackArrayE3 {
        private int maxSize;
        private char[] stackArray;
        private int top;

        public StackArrayE3(int size) {
            this.maxSize = size;
            this.stackArray = new char[maxSize];
            this.top = -1;
        }

        public boolean isFull() {
            return (top == maxSize - 1);
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public void push(char item) {
            if (!isFull()) {
                stackArray[++top] = item;
            }
        }

        public char pop() {
            if (!isEmpty()) {
                return stackArray[top--];
            }
            return '\0';
        }

        public static boolean isBalanced(String str) {
            StackArrayE3 stack = new StackArrayE3(str.length());

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char openBracket = stack.pop();

                    if ((ch == ')' && openBracket != '(') ||
                            (ch == '}' && openBracket != '{') ||
                            (ch == ']' && openBracket != '[')) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }

    class MainE3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Enter an expression with parentheses:");
                String expression = sc.nextLine();

                if (StackArrayE3.isBalanced(expression)) {
                    System.out.println("The expression has balanced parentheses.");
                } else {
                    System.out.println("The expression has imbalanced parentheses.");
                }

            }
        }
    }
