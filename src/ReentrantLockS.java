import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: ConcurrentProgramming
 * @author: mengzy 18306299232@163.com
 * @create: 2020-08-23 15:03
 **/


 interface a{

}

public class ReentrantLockS {
    private int a;


    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

    }
}
