package com.salad.cloud.imdssdk.http;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * SDK Environments
 */
@Getter
@RequiredArgsConstructor
public enum Environment {
  DEFAULT("http://169.254.169.254");

  private final String url;
}
