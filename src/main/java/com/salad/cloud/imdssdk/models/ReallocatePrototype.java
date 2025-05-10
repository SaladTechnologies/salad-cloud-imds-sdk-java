package com.salad.cloud.imdssdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to reallocate the current container instance to another SaladCloud node.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class ReallocatePrototype {

  /**
   * The reason for reallocating the current container instance. This value is reported to SaladCloud support for quality assurance purposes of SaladCloud nodes.
   */
  @NonNull
  private String reason;
}
