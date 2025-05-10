package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.Token;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.StringValidator;

public class TokenValidator extends AbstractModelValidator<Token> {

  public TokenValidator(String fieldName) {
    super(fieldName);
  }

  public TokenValidator() {}

  @Override
  protected Violation[] validateModel(Token token) {
    return new ViolationAggregator()
      .add(new StringValidator("jwt").minLength(1).maxLength(1000).required().validate(token.getJwt()))
      .aggregate();
  }
}
