package week_10.status;public class ThreadYieldExample implements Runnable {    boolean suspend = false;    boolean stopped = false;    Thread th;    public ThreadYieldExample(String name) {        th = new Thread(this, name); // Thread(Runnable r, String name)    }    @Override    public void run() {        String name = th.getName();        while (!stopped) {            if (!suspend) {                System.out.println(name);                try {                    Thread.sleep(1000);                } catch (InterruptedException e) {                    System.out.println(name + " - interrupted");                }            }        }    }}