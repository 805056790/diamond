/*
 * Copyright 2015 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.taobao.diamond.client;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ��TestSchedulerExecutor.java��ʵ��������TODO ��ʵ������
 * 
 * @author macun.mc 2015��12��7�� ����2:43:04
 */
public class TestSchedulerExecutor {

    private ScheduledExecutorService scheduledExecutor;
    private boolean                  isRun       = false;
    private boolean                  bFirstCheck = true;
    private int                      count       = 0;

    public TestSchedulerExecutor(){
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    }

    public static void main(String[] args) {
        TestSchedulerExecutor scheduler = new TestSchedulerExecutor();
        scheduler.start();
    }

    public void start() {
        // ��ʼ�����
        isRun = true;
        rotate();
    }

    public void rotate() {
        scheduledExecutor.scheduleWithFixedDelay(new Runnable() {

            public void run() {
                if (!isRun) {
                    System.out.println("DiamondSubscriber��������״̬�У��˳���ѯѭ��");
                    return;
                }
                try {
                    checkLocalConfigInfo();

                } catch (Exception e) {
                    e.printStackTrace();
                }
//                 finally {
//                 rotate();
//                 }
            }

        }, bFirstCheck ? 60L : 15L, 10L,TimeUnit.SECONDS);
        bFirstCheck = false;
    }

    private void checkLocalConfigInfo() {
        System.out.println("count:" + count++);
    }
}
