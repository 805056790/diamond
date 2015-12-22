/*
 * Copyright 2015 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.taobao.diamond.client;

import java.util.concurrent.Executor;

import com.taobao.diamond.manager.DiamondManager;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;

/**
 * ��DiamondClientTest.java��ʵ��������TODO ��ʵ������ 
 * @author macun.mc 2015��12��4�� ����9:10:59
 */
public class DiamondClientTest {

    public static void main(String[] args){
        String group="DEFAULT_GROUP";
        String dataId="Test123";
        
        DiamondManager manager = new DefaultDiamondManager(group,dataId,new ManagerListener(){
            @Override
            public Executor getExecutor() {
                System.out.println("diamond client test executor.");
                return null;
            }
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("diamond client test:"+configInfo);
                
            }
        });
    }
}
