package com.salad.cloud.imdssdk.config;

import com.salad.cloud.imdssdk.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Builder
@Data
public class SaladCloudImdsSdkConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "imdssdk/1.0.0";

  @Setter
  private String baseUrl;

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;

  public void setEnvironment(Environment environment) {
    this.baseUrl = environment.getUrl();
  }
}
