package day01;

import java.util.concurrent.*;

/**
 * callable
 * 有返回值
 * 可以抛出异常
 */
public class TestCallable implements Callable {
    public Boolean call() throws Exception {
        WebDownloader1 webDownloader = new WebDownloader1();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    private String url; //网络图片位置
    private String name; //保存文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("http://n.sinaimg.cn/news/transform/w150h150/20180223/xbJU-fyrswmv2029131.jpg","t1.jpg");
        TestCallable t2 = new TestCallable("http://n.sinaimg.cn/photo/400/w200h200/20210416/a6a4-knvsnuf5950596.jpg","t2.jpg");
        TestCallable t3 = new TestCallable("http://n.sinaimg.cn/photo/400/w200h200/20210416/7e6a-knvsnuf5870869.jpg","t3.jpg");

        //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> f1 = executorService.submit(t1);
        Future<Boolean> f2 = executorService.submit(t2);
        Future<Boolean> f3 = executorService.submit(t3);

        //获取结果
        boolean rs1 = f1.get();
        boolean rs2 = f2.get();
        boolean rs3 = f3.get();

        //关闭服务
        executorService.shutdownNow();
    }
}
