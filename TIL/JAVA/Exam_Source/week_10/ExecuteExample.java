package week_10;public class ExecuteExample {    public static void main(String[] args) {        // Runnable을 사용하여 Thread 생성        RunnableExample runnable = new RunnableExample();        new Thread(runnable).start();        // Thread를 사용하여 Thread 생성        ThreadExample thread = new ThreadExample("t");        thread.start();    }}