package com.salad.cloud.imdssdk.models;

import com.salad.cloud.imdssdk.validation.annotation.Length;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents a request to reallocate a container.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ReallocateContainer {

  /**
   * The reason for reallocating the container. This value is reported to SaladCloud support for quality assurance of Salad Nodes.
   */
  @NonNull
  @Length(min = 1, max = 1000)
  private String reason;
}
