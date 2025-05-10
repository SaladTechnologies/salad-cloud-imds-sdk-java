package com.salad.cloud.imdssdk.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

/**
 * The identity token of the current container instance.
 */
@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class Token {

  /**
   * The JSON Web Token (JWT) that may be used to identify the running container. The JWT may be verified using the JSON Web Key Set (JWKS) available at https://matrix-rest-api.salad.com/.well-known/workload-jwks.json.
   */
  @NonNull
  private String jwt;
}
