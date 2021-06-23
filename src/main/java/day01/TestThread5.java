package day01;


// 多个线程操作同一个资源，数据紊乱
// 并发问题
public class TestThread5 implements Runnable {

    private int tickNums = 10;

    public void run() {
        while (true) {
            if (tickNums<0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+tickNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread5 testThread5 = new TestThread5();

        new Thread(testThread5,"小明").start();
        new Thread(testThread5,"老板").start();
        new Thread(testThread5,"机器人").start();

    }

}
