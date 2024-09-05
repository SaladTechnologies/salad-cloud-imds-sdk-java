package com.salad.cloud.imdssdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the health statuses of the running container.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerStatus {

  /**
   * `true` if the running container is ready. If a readiness probe is defined, this returns the latest result of the probe. If a readiness probe is not defined but a startup probe is defined, this returns the same value as the `started` property. If neither a readiness probe nor a startup probe are defined, returns `true`.
   */
  @NonNull
  private Boolean ready;

  /**
   * `true` if the running container is started. If a startup probe is defined, this returns the latest result of the probe. If a startup probe is not defined, returns `true`.
   */
  @NonNull
  private Boolean started;
}
