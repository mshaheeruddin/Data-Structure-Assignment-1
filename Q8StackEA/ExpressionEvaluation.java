package Q8StackEA;

import java.util.Scanner;

class PostfixEval {
    boolean flag = false;
    int MAX = 1000;
    int top;
    Object a[] = new Object[MAX];

    PostfixEval() {
        top = -1;
        for (int i = 0; i < MAX; i++)
            a[i] = " ";
    }

    PostfixEval(int size) {
        this.MAX = size;
        top = -1;
        for (int i = 0; i < MAX; i++)
            a[i] = " ";
    }

    public boolean push(String str) {
        if (top >= (MAX - 1)) {
            return false;
        } else {
            top++;
            a[top] = str;
            return true;
        }
    }

    public boolean push(int num) {
        if (top >= (MAX - 1)) {
            return false;
        } else {
            top++;
            a[top] = num;
            return true;
        }
    }

    public Object pop() {
        Object ret = new Object();
        if (top < 0) {
            flag = true;
        } else {
            ret = a[top];
            a[top] = " ";
            top--;
        }
        return ret;
    }

    public int pfEvaluation(String seq) {

        String[] newStr = new String[seq.length()];
       for (int i = 0;i<seq.length();i++) {
           newStr = seq.split(" ");
       }

        for (int i = 0; i < newStr.length; i++) {
            if (!newStr[i].equals("+") && !newStr[i].equals("-") && !newStr[i].equals("/") && !newStr[i].equals("*")) {
                push(Integer.parseInt(String.valueOf(newStr[i])));
            } else if (newStr[i].equals("+")) {
                int num1 = (int) pop();
                int num2 = (int) pop();
                push(num1 + num2);
            } else if (newStr[i].equals("-")) {
                int num1 = (int) pop();
                int num2 = (int) pop();
                push(Math.abs(num1 - num2));
            } else if (newStr[i].equals("/")) {
                int num1 = (int) pop();
                int num2 = (int) pop();
                if (num1 > num2) push(num1 / num2);
                else push(num2 / num1);
            } else if (newStr[i].equals("*")) {
                int num1 = (int) pop();
                int num2 = (int) pop();
                push(num2 * num1);
            }
        }
        System.out.print("Answer is: ");
        return (int) pop();
    }
}

public class ExpressionEvaluation {
    public static void main(String[] args) {
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";
        Scanner in = new Scanner(System.in);
        PostfixEval eval = new PostfixEval();
        System.out.println(ANSI_YELLOW + "PLEASE MAKE SURE THERE IS A GAP BETWEEN EACH ELEMENT OF STRING!" + ANSI_RESET);
        System.out.println("Now Enter Your Postfix Notation: ");
        String str = in.nextLine();
        int ans = eval.pfEvaluation(str);
        System.out.println(ans);

    }
}