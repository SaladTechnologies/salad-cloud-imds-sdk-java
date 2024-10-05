package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.ContainerToken;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.StringValidator;

public class ContainerTokenValidator extends AbstractModelValidator<ContainerToken> {

  public ContainerTokenValidator(String fieldName) {
    super(fieldName);
  }

  public ContainerTokenValidator() {}

  @Override
  protected Violation[] validateModel(ContainerToken containerToken) {
    return new ViolationAggregator()
      .add(new StringValidator("jwt").minLength(1).maxLength(1000).validate(containerToken.getJwt()))
      .aggregate();
  }
}
