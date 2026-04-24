package com.salad.cloud.imdssdk;

import com.salad.cloud.imdssdk.config.SaladCloudImdsSdkConfig;
import com.salad.cloud.imdssdk.http.Environment;
import com.salad.cloud.imdssdk.http.interceptors.DefaultHeadersInterceptor;
import com.salad.cloud.imdssdk.http.interceptors.RetryInterceptor;
import com.salad.cloud.imdssdk.services.MetadataService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** The SaladCloud Instance Metadata Service (IMDS). Please refer to the [SaladCloud API Documentation](https://docs.salad.com/reference) for more details. */
public class SaladCloudImdsSdk {

  public final MetadataService metadata;

  private final SaladCloudImdsSdkConfig config;

  /**
   * Constructs a new instance of SaladCloudImdsSdk with default configuration.
   */
  public SaladCloudImdsSdk() {
    // Default configs
    this(SaladCloudImdsSdkConfig.builder().build());
  }

  /**
   * Constructs a new instance of SaladCloudImdsSdk with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public SaladCloudImdsSdk(SaladCloudImdsSdkConfig config) {
    this.config = config;

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.metadata = new MetadataService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
