package org.rabbit.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import lombok.Data;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * https://github.com/square/okhttp/blob/master/samples/simple-client/src/main/java/okhttp3/sample/OkHttpContributors.java
 * https://github.com/square/moshi
 */
public class HttpClient {

    public String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        return execute(request);
    }

    public String post(String url, String json) {
        final MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        return execute(request);
    }

    public String bowlingJson() {
        return "{\"indexId\":\"JR1902190008\","
                + "\"begin\":\"201701\","
                + "\"end\":\"201702\""
                + "}";
    }

    private String execute(Request request) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).build();

        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Data
    static class SnappyJobResult {
        private String jobId;
        private String status;
        private String result;
    }

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = new HttpClient();
        String res = httpClient.get("http://172.16.9.220:7070/snappy/job/get/job/result/7902dda7-e15c-4b24-8cad-3e804726ee01");
        System.out.println(res);

        final Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<SnappyJobResult> jsonAdapter = moshi.adapter(SnappyJobResult.class);
        SnappyJobResult snappyJobResult = jsonAdapter.fromJson(res);
        assert snappyJobResult != null;
        System.out.println(snappyJobResult.getJobId());
        System.out.println(snappyJobResult.getStatus());
        System.out.println(snappyJobResult.getResult());
//


//        String postUrl = "http://172.16.9.220:7070/snappy/job/calculate/index";
//        String json = httpClient.bowlingJson();
//        String res2 = httpClient.post(postUrl, json);
//        System.out.println(res2);
    }
}
