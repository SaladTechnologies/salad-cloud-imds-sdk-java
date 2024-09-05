package com.salad.cloud.imdssdk.config;

import com.salad.cloud.imdssdk.http.Environment;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class SaladCloudImdsSdkConfig {

  @NonNull
  @Builder.Default
  private String userAgent = "imdssdk/1.0.0";

  @NonNull
  @Builder.Default
  private Environment environment = Environment.DEFAULT;

  @NonNull
  @Builder.Default
  private RetryConfig retryConfig = RetryConfig.builder().build();

  /** Timeout in milliseconds */
  @Builder.Default
  private long timeout = 10_000;
}
