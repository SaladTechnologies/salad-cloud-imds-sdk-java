package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.Token;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.StringValidator;

/**
 * Validator implementation for Token model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class TokenValidator extends AbstractModelValidator<Token> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public TokenValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public TokenValidator() {}

  /**
   * Validates the Token model's fields and constraints.
   *
   * @param token The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(Token token) {
    return new ViolationAggregator()
      .add(new StringValidator("jwt").minLength(1).maxLength(1000).required().validate(token.getJwt()))
      .aggregate();
  }
}
