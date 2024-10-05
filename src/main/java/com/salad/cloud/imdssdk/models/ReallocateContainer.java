package com.salad.cloud.imdssdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to reallocate a container.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ReallocateContainer {

  /**
   * The reason for reallocating the container. This value is reported to SaladCloud support for quality assurance of Salad Nodes.
   */
  @NonNull
  private String reason;
}
