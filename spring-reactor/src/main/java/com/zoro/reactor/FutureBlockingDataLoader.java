package com.zoro.reactor;

import java.util.concurrent.*;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/2
 *
 * 等待Future返回结果
 */
public class FutureBlockingDataLoader extends DataLoader {

    @Override
    protected void doLoad() {  // 并行计算

        ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池

        CompletionService completionService = new ExecutorCompletionService(executorService);

        runCompletely(completionService.submit(super::loadConfigurations, null));      //  耗时 >= 1s

        runCompletely(completionService.submit(super::loadUsers, null));               //  耗时 >= 2s

        runCompletely(completionService.submit(super::loadOrders, null));              //  耗时 >= 3s

        executorService.shutdown();

    }  // 总耗时 max(1s, 2s, 3s)  >= 3s

    private void runCompletely(Future<?> future) {
        try {
            future.get(); // 阻塞等待结果执行
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {

        new FutureBlockingDataLoader().load();

    }
}
