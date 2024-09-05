package com.salad.cloud.imdssdk.models;

import com.salad.cloud.imdssdk.validation.annotation.Length;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * Represents the identity token of the running container.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@Jacksonized
public class ContainerToken {

  /**
   * The JSON Web Token (JWT) that may be used to identify the running container. The JWT may be verified using the JSON Web Key Set (JWKS) available at https://matrix-rest-api.salad.com/.well-known/stash-jwks.json.
   */
  @NonNull
  @Length(min = 1, max = 1000)
  private String jwt;
}
