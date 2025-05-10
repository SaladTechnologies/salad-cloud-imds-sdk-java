package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.ReallocatePrototype;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.StringValidator;

public class ReallocatePrototypeValidator extends AbstractModelValidator<ReallocatePrototype> {

  public ReallocatePrototypeValidator(String fieldName) {
    super(fieldName);
  }

  public ReallocatePrototypeValidator() {}

  @Override
  protected Violation[] validateModel(ReallocatePrototype reallocatePrototype) {
    return new ViolationAggregator()
      .add(
        new StringValidator("reason").minLength(1).maxLength(1000).required().validate(reallocatePrototype.getReason())
      )
      .aggregate();
  }
}
