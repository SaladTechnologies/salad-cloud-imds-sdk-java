package com.salad.cloud.imdssdk.validation.validators;

import com.salad.cloud.imdssdk.validation.Violation;

public interface Validator<T> {
  Violation[] validate(T value);
}
