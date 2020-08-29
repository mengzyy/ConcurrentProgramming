import java.util.concurrent.atomic.AtomicInteger;

/**
 * WHAT:  CAS的全称是比较并交换 字面上的意思是“Compare And Swap”
 * 一个CAS主要涉及以下的操作：内存中的数据V，原值为A，新的值为B
 * ->如果V和A相等，那么将A改为B，否则不做操作
 * FEATURE:CAS主要有以下的优点，可以使得线程在并发环境中一直自旋，不会导致线程的阻塞，减少线程的上下切换，缺点是在高并发的情况下，多个线程一直运行会消耗cpu资源。
 * 底层主要是通过unsafe类方法调用本地方法来实现的。
 * HOW:    应用：比如说一些自旋锁等等。
 *
 * @program: ConcurrentProgramming
 * @author: mengzy 18306299232@163.com
 * @create: 2020-08-23 13:31
 **/
public class Cas {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    /*不断的自旋*/
                    while (true) {
                        /*cas成功的话直接退出*/
                        if (atomicInteger.compareAndSet(0, 1)) {
                            System.out.println("成功修改为1");
//                            try {
//                                Thread.sleep(10000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                            atomicInteger.decrementAndGet();
                            break;
                        }
                    }
                }
            }).start();
        }
    }
}
