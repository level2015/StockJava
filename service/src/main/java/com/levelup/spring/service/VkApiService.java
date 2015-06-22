package com.levelup.spring.service;

import com.levelup.spring.service.impl.VkApiServiceImpl;

import java.io.IOException;

/**
 * Created by SMULL on 6/22/2015.
 */
public interface VkApiService {

    String getDialogs()throws IOException;
    String getHistory(String userId, int offset, int count, boolean rev)throws IOException;
    String getAlbums(String userId)throws IOException;
    VkApiServiceImpl with(String appId, String accessToken) throws IOException;
    VkApiServiceImpl on() throws IOException;



}
