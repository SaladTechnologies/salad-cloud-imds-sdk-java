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

/** The SaladCloud Instance Metadata Service (IMDS). Please refer to the [SaladCloud API Documentation](https://docs.salad.com/reference) for more details. */
public class SaladCloudImdsSdk {

  public final MetadataService metadata;

  private final SaladCloudImdsSdkConfig config;

  private final HookInterceptor hookInterceptor;

  public SaladCloudImdsSdk() {
    // Default configs
    this(SaladCloudImdsSdkConfig.builder().build());
  }

  public SaladCloudImdsSdk(SaladCloudImdsSdkConfig config) {
    this.config = config;

    this.hookInterceptor = new HookInterceptor(new CustomHook());

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(hookInterceptor)
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.metadata = new MetadataService(httpClient, config);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
