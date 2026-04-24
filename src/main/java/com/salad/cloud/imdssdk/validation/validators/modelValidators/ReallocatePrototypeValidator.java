package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.ReallocatePrototype;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;
import com.salad.cloud.imdssdk.validation.validators.StringValidator;

/**
 * Validator implementation for ReallocatePrototype model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ReallocatePrototypeValidator extends AbstractModelValidator<ReallocatePrototype> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ReallocatePrototypeValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ReallocatePrototypeValidator() {}

  /**
   * Validates the ReallocatePrototype model's fields and constraints.
   *
   * @param reallocatePrototype The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ReallocatePrototype reallocatePrototype) {
    return new ViolationAggregator()
      .add(
        new StringValidator("reason").minLength(1).maxLength(1000).required().validate(reallocatePrototype.getReason())
      )
      .aggregate();
  }
}
