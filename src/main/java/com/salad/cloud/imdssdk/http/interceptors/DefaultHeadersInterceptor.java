package com.salad.cloud.imdssdk.http.interceptors;

import com.salad.cloud.imdssdk.config.SaladCloudImdsSdkConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class DefaultHeadersInterceptor implements Interceptor {

  private final Map<String, String> defaultHeaders = new HashMap<>();

  public DefaultHeadersInterceptor(SaladCloudImdsSdkConfig config) {
    defaultHeaders.put("User-Agent", config.getUserAgent());
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    return chain.proceed(addDefaultHeadersToRequest(chain.request()));
  }

  private Request addDefaultHeadersToRequest(Request request) {
    if (defaultHeaders.isEmpty()) {
      return request;
    }

    Builder requestBuilder = request.newBuilder();

    defaultHeaders.forEach(requestBuilder::addHeader);

    return requestBuilder.build();
  }
}
