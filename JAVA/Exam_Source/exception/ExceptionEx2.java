package exception;public class ExceptionEx2 {    public static void main(String[] args) {        System.out.println(1);        System.out.println(2);        try {            System.out.println(3);            System.out.println(0 / 0);            System.out.println(4);        } catch (ArithmeticException e) {            System.out.println(5);        } // try - catch 끝        System.out.println(6);    } // main 끝}