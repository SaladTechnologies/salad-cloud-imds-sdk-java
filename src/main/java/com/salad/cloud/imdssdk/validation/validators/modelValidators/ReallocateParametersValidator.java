package com.salad.cloud.imdssdk.validation.validators.modelValidators;

import com.salad.cloud.imdssdk.models.ReallocateParameters;
import com.salad.cloud.imdssdk.validation.Violation;
import com.salad.cloud.imdssdk.validation.ViolationAggregator;

/**
 * Validator implementation for ReallocateParameters model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ReallocateParametersValidator extends AbstractModelValidator<ReallocateParameters> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ReallocateParametersValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ReallocateParametersValidator() {}

  /**
   * Validates the ReallocateParameters model's fields and constraints.
   *
   * @param requestParameters The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ReallocateParameters requestParameters) {
    return new ViolationAggregator()
      .add(
        new ReallocatePrototypeValidator("reallocatePrototype")
          .required()
          .validate(requestParameters.getReallocatePrototype())
      )
      .aggregate();
  }
}
