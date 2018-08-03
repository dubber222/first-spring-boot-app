package com.zoro.reactor;

import java.util.concurrent.CompletableFuture;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/2
 * <p>
 * CompletableFuture 实现 Future 链式
 */
public class FutureChainDataLoader extends DataLoader {

    public static void main(String[] args) {

        new FutureChainDataLoader().load();

    }

    @Override
    protected void doLoad() {  // 并行计算
        CompletableFuture.runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete(
                        (aVoid, throwable) -> { //完成是回调
                            System.out.println("加载完成");
                        }
                )
                .join(); //等待完成
    }
}
