package com.salad.cloud.imdssdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * The deletion cost of the current container instance.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class DeletionCost {

  /**
   * An integer value that identifies the relative cost to the application running across the container group if the current container instance is deleted. A higher value indicates a higher cost, and a lower value indicates a lower cost. If the container group is scaled down, the scheduler will attempt to delete the container instances with the lowest deletion costs first.
   */
  @NonNull
  @JsonProperty("deletion_cost")
  private Long deletionCost;
}
