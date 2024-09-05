package com.salad.cloud.imdssdk;

import com.salad.cloud.imdssdk.config.SaladCloudImdsSdkConfig;
import com.salad.cloud.imdssdk.hook.CustomHook;
import com.salad.cloud.imdssdk.http.Environment;
import com.salad.cloud.imdssdk.http.interceptors.DefaultHeadersInterceptor;
import com.salad.cloud.imdssdk.http.interceptors.HookInterceptor;
import com.salad.cloud.imdssdk.http.interceptors.RetryInterceptor;
import com.salad.cloud.imdssdk.services.MetadataService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** The SaladCloud Instance Metadata Service (IMDS). Please refer to the [SaladCloud API Documentation](https://docs.salad.com/api-reference) for more details. */
public class SaladCloudImdsSdk {

  public final MetadataService metadataService;

  private final HookInterceptor hookInterceptor;

  public SaladCloudImdsSdk() {
    // Default configs
    this(SaladCloudImdsSdkConfig.builder().build());
  }

  public SaladCloudImdsSdk(SaladCloudImdsSdkConfig config) {
    final String serverUrl = config.getEnvironment().getUrl();

    this.hookInterceptor = new HookInterceptor(new CustomHook());

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(hookInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.metadataService = new MetadataService(httpClient, serverUrl);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.metadataService.setBaseUrl(baseUrl);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
