package day01;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{

    private String url; //网络图片位置
    private String name; //保存文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://n.sinaimg.cn/news/transform/w150h150/20180223/xbJU-fyrswmv2029131.jpg","t1.jpg");
        TestThread2 t2 = new TestThread2("http://n.sinaimg.cn/photo/400/w200h200/20210416/a6a4-knvsnuf5950596.jpg","t2.jpg");
        TestThread2 t3 = new TestThread2("http://n.sinaimg.cn/photo/400/w200h200/20210416/7e6a-knvsnuf5870869.jpg","t3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }

}

class WebDownloader{
    public void downloader(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader出现问题");
        }
    }
}
