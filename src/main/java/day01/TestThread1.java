package day01;

//总结：线程开启不一定立即执行，由CPU调度
public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("这是--"+i);
        }
    }

    public static void main(String[] args) {


        TestThread1 testThread1 = new TestThread1();

//        testThread1.run();调用方法
        //开启线程，线程由cpu调度
        testThread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("it is -- " + i);
        }
    }
}
