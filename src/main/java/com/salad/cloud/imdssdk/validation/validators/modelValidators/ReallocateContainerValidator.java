package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.ReallocateContainer;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.StringValidator;

public class ReallocateContainerValidator extends AbstractModelValidator<ReallocateContainer> {

  public ReallocateContainerValidator(String fieldName) {
    super(fieldName);
  }

  public ReallocateContainerValidator() {}

  @Override
  protected Violation[] validateModel(ReallocateContainer reallocateContainer) {
    return new ViolationAggregator()
      .add(new StringValidator("reason").minLength(1).maxLength(1000).validate(reallocateContainer.getReason()))
      .aggregate();
  }
}
