package Q9StackInfixToPrefix;

import java.util.ArrayList;

class ConversionInfixToPrefix {
    boolean flag = false;
    static final int MAX = 1000;
    int top;
    String a[]= new String[MAX];

    ConversionInfixToPrefix()
    {
        top = -1;
        for (int i=0;i<MAX;i++)
            a[i]=" ";
    }

    public boolean push(String str)
    {
        if (top >= (MAX - 1)){
            return false;
        }
        else {
            top++;
            a[top] = str;
            return true;
        }
    }

    public String pop() {
        String str  = null;
        if (top < 0) {
            flag = true;
        }
        else {
            str=a[top];
            a[top]= " ";
            top--;

           }
            return str;
         }
    public String convertToPostfix(String infix) {
        String[] newStr = new String[infix.length()];
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0;i<infix.length();i++) {
            newStr = infix.split(" ");
        }
        for (int i = 0;i<newStr.length;i++) {
            if (!newStr[i].equals("+") && !newStr[i].equals("-") && !newStr[i].equals("/") && !newStr[i].equals("*") &&
            !newStr[i].equals(")")&& !newStr[i].equals("(")) {
                arrayList.add(newStr[i]);
            }
            else if (newStr[i].equals("(") || newStr[i].equals("+") || newStr[i].equals("-")
                    || newStr[i].equals("/") || newStr[i].equals("*")) {
                   push(newStr[i]);
            }
            else if (newStr[i].equals(")")) {
                boolean flag = false;
                do {
                    String pop = pop();
                    if (pop.equals("(")) {
                        flag = false;
                    }
                    else {
                        flag = true;}
                    if (!pop.equals("(") && !pop.equals(")")) arrayList.add(pop);
                }
                while(flag == false);

            }
        }
        String postFix = "";
        for (int i = 0;i<arrayList.size();i++) {
            postFix = postFix.concat(arrayList.get(i));
        }
        return postFix;
    }
    String convertToPrefix(String str) {
        String postfix = convertToPostfix(str);
        //Reverse
        String prefix = "";
        for(int i = postfix.length()-1;i>=0;i--) {
            prefix = prefix.concat(String.valueOf(postfix.charAt(i)));
        }

        return prefix;
    }

     }

    public class InfixToPrefix {
    public static void main(String[] args) {
           ConversionInfixToPrefix c = new ConversionInfixToPrefix();

        System.out.println(c.convertToPostfix("( ( ( A + B ) * C ) - ( ( D + E ) / F ) )"));
        System.out.println(c.convertToPrefix(" ( ( ( A + B ) * C ) - ( ( D + E ) / F ) )"));

    }
}