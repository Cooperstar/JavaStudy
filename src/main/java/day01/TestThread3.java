package day01;

//方式2：实现Runnable接口，重写run方法(推荐)
public class TestThread3 implements Runnable {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("这是--"+i);
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口实现类
        TestThread3 testThread3 = new TestThread3();

        //创建线程对线，通过线程对象开启线程，代理
        new Thread(testThread3).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("it is -- " + i);
        }
    }
}
