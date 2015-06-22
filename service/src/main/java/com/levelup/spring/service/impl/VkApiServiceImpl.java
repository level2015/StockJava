package com.levelup.spring.service.impl;

import com.levelup.spring.service.VkApiService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by SMULL on 6/22/2015.
 */
@Service("vkApiServiceImpl")
public class VkApiServiceImpl implements VkApiService {

    public static final String API_VERSION = "5.34";

    private static final String email = "380665581337";
    private static final String pass = "122qqq122";

    private static final String url122 = "https://vk.com/login.php?m=1&email=" + email + "&pass=" + pass;
    private static final String url = "https://login.vk.com/?act=login&utf8=1";

    private final String accessToken;

    //String response = sendHttpsRequest(url, "testing", "Location");


    public VkApiServiceImpl() {
        this.accessToken = null;
    }

    private static final String AUTH_URL = "https://oauth.vk.com/authorize"
            + "?client_id={APP_ID}"
            + "&scope={PERMISSIONS}"
            + "&redirect_uri={REDIRECT_URI}"
            + "&display={DISPLAY}"
            + "&v={API_VERSION}"
            + "&response_type=token";

    private static final String MY_AUTH_URL = "https://oauth.vk.com/authorize"
            + "?client_id={APP_ID}"
            + "&scope={PERMISSIONS}"
            + "&redirect_uri={REDIRECT_URI}"
            + "&response_type=token"
            + "&v={API_VERSION}";




    private static final String API_REQUEST = "https://api.vk.com/method/{METHOD_NAME}"
            + "?{PARAMETERS}"
            + "&access_token={ACCESS_TOKEN}"
            + "&v=" + API_VERSION;

//       public static VkApiServiceImpl with(String appId, String accessToken) throws IOException {
//        return new VkApiServiceImpl(appId, accessToken);
//    }


    public  VkApiServiceImpl with(String appId, String accessToken) throws IOException {
        return new VkApiServiceImpl(appId, accessToken);
    }

    public  VkApiServiceImpl on() throws IOException {
        return new VkApiServiceImpl(APP_ID, null);
    }

    private VkApiServiceImpl(String appId, String accessToken) throws IOException {
        this.accessToken = accessToken;
        if (accessToken == null || accessToken.isEmpty()) {
            auth(appId);
            throw new Error("Need access token");
        }
    }

    private void auth(String appId) throws IOException {
        String reqUrl = AUTH_URL
                .replace("{APP_ID}", appId)
                .replace("{PERMISSIONS}", "photos,messages")
                .replace("{REDIRECT_URI}", "https://oauth.vk.com/blank.html")
                .replace("{DISPLAY}", "page")
                .replace("{API_VERSION}", API_VERSION);

        try {
            Desktop.getDesktop().browse(new URL(reqUrl).toURI());

        } catch (URISyntaxException ex) {
            throw new IOException(ex);
        }
    }

    public String getDialogs() throws IOException {
        return invokeApi("messages.getDialogs",null);
    }

    public String getHistory(String userId, int offset, int count, boolean rev) throws IOException {
        return invokeApi("messages.getHistory", Params.create()
                .add("user_id", userId)
                .add("offset", String.valueOf(offset))
                .add("count", String.valueOf(count))
                .add("rev", rev ? "1" : "0"));
    }

    public String getAlbums(String userId) throws IOException {
        return invokeApi("photos.getAlbums", Params.create()
                .add("owner_id", userId)
                .add("photo_sizes", "1")
                .add("thumb_src", "1"));
    }

    private String invokeApi(String method, Params params) throws IOException {
        final String parameters = (params == null) ? "" : params.build();
        String reqUrl = API_REQUEST
                .replace("{METHOD_NAME}", method)
                .replace("{ACCESS_TOKEN}", accessToken)
                .replace("{PARAMETERS}&", parameters);
        return invokeApi(reqUrl);
    }

    private static String invokeApi(String requestUrl) throws IOException {
        final StringBuilder result = new StringBuilder();
        final URL url = new URL(requestUrl);
        try (InputStream is = url.openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            reader.lines().forEach(result::append);
        }
        return result.toString();
    }

    private static class Params {

        public static Params create() {
            return new Params();
        }

        private final HashMap<String, String> params;

        private Params() {
            params = new HashMap<>();
        }


        public Params add(String key, String value) {
            params.put(key, value);
            return this;
        }

        public String build() {
            if (params.isEmpty()) return "";
            final StringBuilder result = new StringBuilder();
            params.keySet().stream().forEach(key -> {
                result.append(key).append('=').append(params.get(key)).append('&');
            });
            return result.toString();
        }
    }
    private static String secret = "1a5c1df263f5e437235a8782068ae1d508d91a4ae689a705efcef923a975576d3deeeea087418db01163c";
    private static String APP_ID = "4966616";

//    public static void main(String[] args) throws IOException {
//
////            URL urls = new URL(MY_AUTH_URL);
////            HttpsURLConnection con = (HttpsURLConnection) urls.openConnection();
////            BufferedReader br =
////                    new BufferedReader(
////                            new InputStreamReader(con.getInputStream()));
////
////            String input;
////            int responseCode = con.getResponseCode();
////            System.out.println(responseCode);
//        //Desktop.getDesktop().browse(new URL(url).toURI());
//
//
////        String s = "ac91d0b68d61edc74ad7ad4509438f483466ca61ed5400e787d3fd8cc3e500d3a5201a87c48fca85d30ee";
////
//        // String login1 = "feed";
////
////        String login2 = "id132939752";
//        //VkApi vkApi = new VkApi(APP_ID,null);
////        VkApi vkApi = new VkApi(APP_ID, null);
//        VkApiServiceImpl.with(APP_ID, null);
////        VkApi.with(login2,secret);
//        //VkApi.with(login1,null);
//
////
//        //System.out.println(vkApi.getDialogs());
//
//
//
//
//
//    }


}
