package com.salad.cloud.imdssdk.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Metadata {
  TRUE("true");

  @JsonValue
  private final String value;

  @JsonCreator
  public static Metadata fromValue(String value) {
    return Arrays.stream(Metadata.values()).filter(item -> item.value.equals(value)).findFirst().orElse(null);
  }
}
